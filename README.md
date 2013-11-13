PasswordComplexityService
=========================

Password Complexity Service configurable via IoC 

A password compliance rule can be created by Extending the PasswordComplianceRule object, which will require you to implement a validates method.


To enable/disable a PasswordComplianceRule rule, you must create a bean in spring-config.xml, and add it to the list of beans in the masterValidator bean defintion.


For example, to add a new a new FooRule, you would create the class com.brett.PasswordComplianceService.ComplianceRule.FooRule, and add the fooRule bean as shown below.


As a more concrete example, you can change from password length of 5 to 12 exclusive to 5 to 12 inclusive, by uncommenting betweenFiveAndTwleveCharsInclusiveBean and commenting out betweenFiveAndTwleveCharsExclusiveBean

```html
<bean id="masterValidator" class="com.brett.PasswordComplianceService.MasterValidator">
        <property name="validators">
            <list>
                <ref bean="lowerCaseAndNumericalOnlyBean"/>
                <ref bean="betweenFiveAndTwleveCharsExclusiveBean"/>
                <!--ref bean="betweenFiveAndTwleveCharsInclusiveBean"/-->
                <ref bean="fooRule">
            </list>
        </property>
    </bean>
    
<bean id="lowerCaseAndNumericalOnlyBean" class="com.brett.PasswordComplianceService.ComplianceRule.LowerCaseAndNumericalOnly"/>
<bean id="betweenFiveAndTwleveCharsInclusiveBean" class="com.brett.PasswordComplianceService.ComplianceRule.BetweenFiveAndTwelveCharsExclusive"/>
<bean id="betweenFiveAndTwleveCharsExclusiveBean" class="com.brett.PasswordComplianceService.ComplianceRule.BetweenFiveAndTwelveCharsExclusive"/>
<bean id="fooRule" class="com.brett.PasswordComplianceService.ComplianceRule.FooRule"/>
```    

Note: It is incumbent upon the user to avoid using conflicting PasswordComplianceRules
Also note: SpringAppTests.java assumes the presence of 3 specific tests. If you enable/disable validations per the above, you may need to modify this test as well.

Tests
=========================
The application is deployed to http://passwordcomplexityservice.herokuapp.com/validate

You can test it by running any of the CURL scripts located in the project test directory

