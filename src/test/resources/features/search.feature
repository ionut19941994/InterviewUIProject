Feature: Actions on a e-commerce website

  Scenario Outline: Add to cart 2 products and assert the operation
    Given that the user is on the landing page
    And he is able to search for '<product1>'
    When the user clicks on add to basket button
    And he is able to search for '<product2>'
    And the user clicks on add to basket button
    Then he is able to navigate to the basket page
    And the user will see that the basket was updated with '<product1>'
    And the user will see that the basket was updated with '<product2>'

    Examples:
      | product1 | product2 |
      | Telefon  | Radio    |

  Scenario Outline: Add to cart 2 products and delete 1 and assert
    Given that the user is on the landing page
    And he is able to search for '<product1>'
    And the user clicks on add to basket button
    And he is able to search for '<product2>'
    And the user clicks on add to basket button
    And he is able to navigate to the basket page
    And the user will see that the basket was updated with '<product1>'
    And the user will see that the basket was updated with '<product2>'
    Then he is able to delete an item from the cart
    And he sees that the item '<product1>' is not present anymore in the cart

    Examples:
      | product1 | product2 |
      | Telefon  | Radio    |

  Scenario Outline: Add to cart 2 products and delete them and assert
    Given that the user is on the landing page
    And he is able to search for '<product1>'
    And the user clicks on add to basket button
    And he is able to search for '<product2>'
    And the user clicks on add to basket button
    And he is able to navigate to the basket page
    And the user will see that the basket was updated with '<product1>'
    And the user will see that the basket was updated with '<product2>'
    And he is able to delete an item from the cart
    And he sees that the item '<product2>' is not present anymore in the cart
    Then he is able to delete an item from the cart
    And he sees that no items are present anymore

    Examples:
      | product1 | product2 |
      | Telefon  | Radio    |

  Scenario Outline: Add to cart 2 products and delete them and try to remove again
    Given that the user is on the landing page
    And he is able to search for '<product1>'
    And the user clicks on add to basket button
    And he is able to search for '<product2>'
    And the user clicks on add to basket button
    And he is able to navigate to the basket page
    And the user will see that the basket was updated with '<product1>'
    And the user will see that the basket was updated with '<product2>'
    And he is able to delete an item from the cart
    And he sees that the item '<product2>' is not present anymore in the cart
    Then he is able to delete an item from the cart
    And he sees that no items are present anymore
    And he is not able to delete any more item from the cart

    Examples:
      | product1 | product2 |
      | Telefon  | Radio    |

