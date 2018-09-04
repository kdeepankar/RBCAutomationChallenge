# RBC Automation Challenge

## Selenium Automation test script to buy a Magic Mouse from an e-commerce website.

### STEPS TO FOLLOW:
- STEP 1: Go to http://store.demoqa.com/
- STEP 2: Go to Product category and select Accessories
- STEP 3: Click on “Add to Cart” for just Magic Mouse
- STEP 4: Click on “Checkout” and confirm you have 1 Magic Mouse in your Check-Out Page
- STEP 5: After confirming, click on Continue
- STEP 6: Enter test (dummy) data needed for email, billing/contact details and click Purchase
- STEP 7: Confirm that you have placed the Order in ‘Transaction Results’ page

# RESULTS:

| Total # of Tests     | # of Tests Passed    | # of Tests Failed|
| :------------------: | :------------------: |:---------------:|
| 9                    | 4                    | 5               |

| Test Case #          | Description          | Details	Result with Comments |
| :------------------- | :------------------- |:----------------|
| Step 1               | Go to http://store.demoqa.com/ | Pass, will only fail if you are not connected to the internet. |
| Step 2               | Go to Product category and select Accessories | Pass, if somehow does not find the element on the url, an exception is thrown.   |
| Step 3               | Click on “Add to Cart” for just Magic Mouse | Pass            |
| Step 4 & Step 5      | Click on “Checkout” and confirm you have 1 Magic Mouse in your Check-Out AND click on Continue | Pass, checks the required conditions, if met it passes, if not then an error message will be displayed.  |
| Step 6               | Scenario 1 : Various fields are tried, in the first scenario, all correct fields are entered | PASS  |
| Step 6               | Scenario 2 : All numbers are entered in all the fields.                  | FAIL            |
| Step 6               | Scenario 3 : Correct data is entered, but the first name field is kept empty.   | FAIL              |
| Step 6               | $Scenario 4 : Correct data is entered, but the last name field is kept empty, while checking a long address of over 100 characters.                 | FAIL, However it does validate the long address            |
| Step 6               | Scenario 5 : Correct data is entered, but in the name field a Chinese character is passed. | PASS            |
| Step 6               | Scenario 6 : Correct data is entered, while checking tld for email.                  | PASS             |
| Step 6               | Scenario 7 : Correct data is entered, while checking tld for email.                | PASS           |
| Step 6               | Scenario 8 : Correct data is entered, while checking different language for email.        | FAIL            |
| Step 6               | Scenario 9 : Different language is used for all the fields.                   | FAIL              |	
| Step 7               | Confirm that you have placed the Order in ‘Transaction Results’ page        | PASS, class name is checked on transaction page, if returned then the test is PASS or else an error message is displayed.              |		









