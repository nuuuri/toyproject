import styled from "styled-components";
import { ReactComponent as menuIcon } from "assets/images/icons8-menu.svg";

export default function Header(props: { toggleIsFullScreen: Function }) {
  return (
    <Container>
      <MenuIcon onClick={() => props.toggleIsFullScreen()} />
    </Container>
  );
}

const Container = styled.div`
  display: flex;
  align-items: center;
  height: 50px;
  background: lightblue;
`;
const MenuIcon = styled(menuIcon)`
  margin-left: 20px;
  filter: invert(1);
  cursor: pointer;
`;
