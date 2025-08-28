import { App } from "./app";

describe(("App Test"), () => {
  let component: App;

  beforeEach(() => {
    component = new App();
  });

  it("Palindrome Test Case 1", () => {
    let result = component.isPalindrome("madam");
    expect(result).toBe(true);
  });
    it("Palindrome Test Case 2", () => {
    let result = component.isPalindrome("avik");
    expect(result).toBe(false);
  });

});
