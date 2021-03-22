Feature: Grolls cart
  Put 2 black T-shirts, in size Small in the cart.

Scenario: Put 2 black T-shirts, in size S in the cart.
  Given I have navigated to the T-shirt site
  And I select size Small
  And the amount is 2
  When I press "Lägg i varukorgen"
  Then the result should be 2 T-shirts in size Small in the cart

