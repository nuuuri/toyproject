import { makeAutoObservable } from "mobx";

class store {
  isFullScreen = false;

  constructor() {
    makeAutoObservable(this);
  }

  toggleIsFullScreen() {
    this.isFullScreen = !this.isFullScreen;
  }
}

const LayoutStore = new store();
export { LayoutStore };
