import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
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
          <Navigation.Menu href="/" text="홈" />
          <Navigation.Menu href="/post" text="게시판" />
          <Navigation.Menu href="/" text="페이지" />
        </Container>
      )}
    </>
  );
}

Navigation.Menu = function NavigationMenu(props: {
  href: string;
  text: string;
}) {
  const navigate = useNavigate();

  return <Menu onClick={() => navigate(props.href)}>{props.text}</Menu>;
};

const Container = styled.div<{ isRender: boolean }>`
  position: absolute;
  box-sizing: border-box;
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 250px;
  height: calc(100vh - 50px);
  padding-top: 10px;
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
const Menu = styled.div`
  margin: 5px 0;
  font-weight: 600;
  font-size: 15px;
  color: #444;
  cursor: pointer;
`;
