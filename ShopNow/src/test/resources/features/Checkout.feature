@checkoutprocess
Feature: This feature is for checkout flow

  Scenario Outline: Checkout flow
    Given Im on the browser
    When Navigate to <Shopping Site>
    And search for a '<product>' on homepage
    And click on any one product from search result
    And Add the product to cart from product details page
    And verify the added product in cart
    And click on place order
    And proceed with checkout after login '<email>' '<otp>'

    #And Add address
    #And Select a payment option
    #Then verify the order summary
    Examples: 
      | Shopping Site             | product | email                  | otp |
      | https://www.flipkart.com/ | Laptop  | zenda99.mani@gmail.com |     |
