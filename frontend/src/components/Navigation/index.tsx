import { useEffect, useState } from "react";
import styled from "styled-components";

export default function Navigation(props: { isFullScreen: boolean }) {
  const { isFullScreen } = props;
  const [isRender, setIsRender] = useState(!isFullScreen);

  useEffect(() => {
    if (!isFullScreen) {
      setIsRender(true);
    }
  }, [isFullScreen]);

  return (
    <>
      {isRender && (
        <Container
          isRender={!isFullScreen}
          onAnimationEnd={() => {
            if (isFullScreen) {
              setIsRender(false);
            }
          }}
        >
          <div>menu 1</div>
          <div>menu 2</div>
          <div>menu 3</div>
        </Container>
      )}
    </>
  );
}

const Container = styled.div<{ isRender: boolean }>`
  position: absolute;
  width: 250px;
  height: calc(100vh - 50px);
  background: #f1f1f1;
  animation: ${(props) => (props.isRender ? "slideIn 0.3s" : "slideOut 0.3s")};
  animation-fill-mode: both;

  @keyframes slideIn {
    from {
      left: -250px;
    }
    to {
      left: 0;
    }
  }
  @keyframes slideOut {
    from {
      left: 0;
    }
    to {
      left: -250px;
    }
  }
`;
