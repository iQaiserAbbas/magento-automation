# Project Run Guide

Follow these instructions to correctly setup and run the project. 

## Setup Phase

1. **Dependency Installation**: 
   Begin the setup by installing all the dependencies specified in the `pom.xml` file.

2. **Running testng.xml**: 
   After installing the dependencies, execute the `testng.xml` located in the `src/main/resources` directory.

## Execution Phase

The execution of `testng.xml` will perform the following test cases:

1. Login Test
Navigate to the login page.
Perform login with user credentials.
Verify redirection to the dashboard.
2. Product Search Test
Input product name in search bar.
Execute search.
Check for the presence of correct search results.
3. Add to Cart Test
Select a specific product.
Choose details (e.g., color, size).
Add the product to the cart.
4. Checkout Test
Opt for a shipping method.
Click on 'Next'.
Finalize purchase by clicking 'Place Order'.

For additional support or queries, feel free to open an issue on this repository. Happy testing!
