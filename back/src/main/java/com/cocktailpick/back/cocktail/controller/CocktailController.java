package com.cocktailpick.back.cocktail.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cocktailpick.back.cocktail.dto.CocktailDetailResponse;
import com.cocktailpick.back.cocktail.dto.CocktailRequest;
import com.cocktailpick.back.cocktail.dto.CocktailResponse;
import com.cocktailpick.back.cocktail.dto.UserRecommendRequest;
import com.cocktailpick.back.cocktail.service.CocktailService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/cocktails")
public class CocktailController {
	private final CocktailService cocktailService;

	public CocktailController(CocktailService cocktailService) {
		this.cocktailService = cocktailService;
	}

	@GetMapping
	public ResponseEntity<List<CocktailResponse>> findCocktails() {
		return ResponseEntity.ok(cocktailService.findAllCocktails());
	}

	@GetMapping("/pages")
	public ResponseEntity<List<CocktailResponse>> findPagedCocktails(@RequestParam long id, @RequestParam int size) {
		List<CocktailResponse> cocktailResponses = cocktailService.findPagedCocktails(id, size);
		return ResponseEntity.ok(cocktailResponses);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CocktailDetailResponse> findCocktail(@PathVariable Long id) {
		return ResponseEntity.ok(cocktailService.findCocktail(id));
	}

	@PostMapping
	public ResponseEntity<Void> addCocktail(@RequestBody @Valid CocktailRequest cocktailRequest) {
		Long saveId = cocktailService.save(cocktailRequest);
		return ResponseEntity.created(URI.create("/api/cocktails/" + saveId)).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> updateCocktail(@PathVariable Long id,
		@RequestBody @Valid CocktailRequest cocktailRequest) {
		cocktailService.updateCocktail(id, cocktailRequest);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCocktail(@PathVariable Long id) {
		cocktailService.deleteCocktail(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/today")
	public ResponseEntity<CocktailResponse> findCocktailOfToday() {
		return ResponseEntity.ok(cocktailService.findCocktailOfToday());
	}

	@PostMapping("/upload/csv")
	public ResponseEntity<Void> addCocktailsByCsv(@RequestPart MultipartFile file) {
		cocktailService.saveAll(file);
		return ResponseEntity.created(URI.create("/api/cocktails")).build();
	}

	@PostMapping("/recommend")
	public ResponseEntity<List<CocktailDetailResponse>> recommend(
		@RequestBody List<UserRecommendRequest> recommendRequests) {
		List<CocktailDetailResponse> cocktailDetailResponses = cocktailService.recommend(recommendRequests);
		return ResponseEntity.ok(cocktailDetailResponses);
	}

	@GetMapping("/auto_complete")
	public ResponseEntity<List<CocktailResponse>> containName(@RequestParam @NotBlank String contain) {
		List<CocktailResponse> cocktailResponses = cocktailService.containName(contain);
		return ResponseEntity.ok(cocktailResponses);
	}
}
