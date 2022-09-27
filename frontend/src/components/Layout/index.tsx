import styled from "styled-components";
import { useState } from "react";
import { Outlet } from "react-router-dom";
import Header from "components/Header";
import Navigation from "components/Navigation";

export default function Layout() {
  const [isFullScreen, setIsFullScreen] = useState(true);

  return (
    <>
      <Header toggleIsFullScreen={() => setIsFullScreen((f) => !f)} />
      <Body>
        <Navigation isFullScreen={isFullScreen} />
        <Page isFullScreen={isFullScreen}>
          <Outlet />
        </Page>
      </Body>
    </>
  );
}

const Body = styled.div`
  position: relative;
  display: flex;
`;
const Page = styled.div<{ isFullScreen: boolean }>`
  position: relative;
  animation: ${(props) => (props.isFullScreen ? "navOff 0.3s" : "navOn 0.3s")};
  animation-fill-mode: both;

  @keyframes navOn {
    from {
      left: 125px;
      width: calc(100% - 250px);
    }
    to {
      left: 250px;
      width: calc(100% - 250px);
    }
  }
  @keyframes navOff {
    from {
      left: 250px;
      width: calc(100% - 250px);
    }
    to {
      left: 125px;
      width: calc(100% - 250px);
    }
  }
`;
