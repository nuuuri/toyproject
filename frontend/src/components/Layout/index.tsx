import Header from "components/Header";
import Navigation from "components/Navigation";
import { Outlet } from "react-router-dom";
import styled from "styled-components";

export default function Layout() {
  return (
    <>
      <Header />
      <Body>
        <Navigation />
        <Outlet />
      </Body>
    </>
  );
}

const Body = styled.div`
  display: flex;
`;
