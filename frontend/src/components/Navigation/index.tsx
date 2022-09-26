import { LayoutStore } from "components/Layout/store";
import { observer } from "mobx-react-lite";
import styled from "styled-components";

export default observer(function Navigation() {
  return (
    <>
      {LayoutStore.isFullScreen && (
        <Container>
          <div>menu 1</div>
          <div>menu 2</div>
          <div>menu 3</div>
        </Container>
      )}
    </>
  );
});

const Container = styled.div`
  width: 250px;
  height: calc(100vh - 50px);
  background: #f1f1f1;
`;
