Feature: As a end user, I want to complete the form (Buy a car) by selecting various fields like drop down and filling text box

  @FormSubmit
  Scenario Outline:As end user, I want to select brand and model to submit the form.
    Given I navigate to the localhost
    # When I select the  brand "<BrandDropDown>"
    #And  I select the model "<ModelDropDown>"
    #Then I submit the form
    #Then close the browser


 Examples:
  |BrandDropDown|ModelDropDown|
  |Chevrolet    |Aveo |


@FormSubmit
  Scenario Outline:As end user, I want to select brand and model and enter a keyword text
    Given I navigate to the localhost
   # When I select the  brand "<BrandDropDown>"
   # And  I select the model "<ModelDropDown>"
   # Then I enter the "<Keyword>"
   # Then I submit the form
   # Then close the browser


 Examples:
  |BrandDropDown|ModelDropDown|Keyword|
  |Chevrolet    |Aveo | sport|


@FormSubmit
  Scenario Outline:Validate the form rest Api response
    Given I send a GET request to "<URL>"
    #Then the response status should be "200"
    #And the AcutalJSON response should be same as ExpectedJson


 Examples:
  |URL|
  |http://localhost:3000/|