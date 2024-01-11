Feature: Place an order for products
  
@OrdersTest
  Scenario Outline: Search for product add to cart and goto checkout page
    Given user is on the GreenCart landing  page
    When user serches with shortname <Name> and extracted actual name of product
    And Added "3" items of the selected product to cart
    Then User proceeds to checkout and validate the <Name> items on checkout page
    And Verify the user has the abbility to enter promo code and place order
    
  Examples:
  | Name |
  | Tom  |
  | Str  |