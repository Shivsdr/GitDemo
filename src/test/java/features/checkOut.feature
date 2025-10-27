Feature: Place the order for Products 


@PlaceOrder
Scenario Outline: Search Experience for product search in both home and Offers page

Given User is on GreenCart Landing page
When user searched with shortname <Name> and extracted actual name of product
And Added "3" items of the selected products to cart
Then User proceeds to Checkout and validate the <Name> items in checkout page
And verify the user has ability to enter promo code and place order

Examples:
|  Name  |
|  Tom   |

