# RBC Automation Challenge

## Selenium Automation test script to buy a Magic Mouse from an e-commerce website.

### STEPS TO FOLLOW:
STEP 1: Go to http://store.demoqa.com/
STEP 2: Go to Product category and select Accessories
STEP 3: Click on “Add to Cart” for just Magic Mouse
STEP 4: Click on “Checkout” and confirm you have 1 Magic Mouse in your Check-Out Page
STEP 5: After confirming, click on Continue
STEP 6: Enter test (dummy) data needed for email, billing/contact details and click Purchase
STEP 7: Confirm that you have placed the Order in ‘Transaction Results’ page

# RESULTS:
Total number of Test Cases	               9
Number of Test Cases Passed	               4
Number of Test Cases Failed	                5

| Fun                  | With                 | Tables          |
| :------------------- | -------------------: |:---------------:|
| left-aligned column  | right-aligned column | centered column |
| $100                 | $100                 | $100            |
| $10                  | $10                  | $10             |
| $1                   | $1                   | $1              |


Test Case #	Description	Details	Result with Comments
1)	Step 1	Go to http://store.demoqa.com/
Pass, will only fail if you are not connected to the internet.
2)	Step 2	Go to Product category and select Accessories	Pass, if somehow does not find the element on the url, an exception is thrown.
3)	Step 3	Click on “Add to Cart” for just Magic Mouse	Pass
4)	Step 4 & Step 5 are executed simultaneously	Click on “Checkout” and confirm you have 1 Magic Mouse in your Check-Out Page AND After confirming, click on Continue
	Pass, checks the required conditions, if met it passes, if not then an error message will be displayed.
5)	Step 6
	Enter test (dummy) data needed for email, billing/contact details and click Purchase
Scenario 1 : Various fields are tried, in the first scenario, all correct fields are entered, so it passes.	 PASS
6)	Step 6	Enter test (dummy) data needed for email, billing/contact details and click Purchase
Scenario 2 : All numbers are entered in all the fields.	FAIL
7)	Step 6	Enter test (dummy) data needed for email, billing/contact details and click Purchase
Scenario 3 : Correct data is entered, but the first name field is kept empty.	FAIL
8)	Step 6	Enter test (dummy) data needed for email, billing/contact details and click Purchase
Scenario 4 : Correct data is entered, but the last name field is kept empty, while checking a long address of over 100 characters.	FAIL
9)	Step 6	Enter test (dummy) data needed for email, billing/contact details and click Purchase
Scenario 5 : Correct data is entered, but in the name field a Chinese character is passed.	PASS
	Step 6 	Enter test (dummy) data needed for email, billing/contact details and click Purchase
Scenario 6 : Correct data is entered, while checking tld for email.	PASS
	Step 6	Enter test (dummy) data needed for email, billing/contact details and click Purchase
Scenario 7 : Correct data is entered, while checking tld for email.	PASS
	Step 6	Enter test (dummy) data needed for email, billing/contact details and click Purchase
Scenario 8 : Correct data is entered, while checking different language for email.	FAIL
	Step 6	Enter test (dummy) data needed for email, billing/contact details and click Purchase
Scenario 9 : Different language is used for all the fields.	FAIL
	Step 7	Confirm that you have placed the Order in ‘Transaction Results’ page
	PASS, class name is checked on transaction page, if returned then the test is PASS or else an error message is displayed.








