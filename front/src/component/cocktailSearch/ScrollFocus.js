import React, { useEffect } from "react";

const ScrollFocus = () => {
  useEffect(() => {
    const highLighted = document.getElementsByClassName("highLight")[0];
    if (!highLighted) {
      return;
    }

    document
      .getElementsByClassName("highLight")[0]
      .scrollIntoView({ block: "center" });
  });

  return <></>;
};

export default ScrollFocus;
