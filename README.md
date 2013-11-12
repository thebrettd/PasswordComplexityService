PasswordComplexityService
=========================

Password Complexity Service configurable via IoC 

A password compliance rule can be created by Extending the PasswordComplianceRule object, which will require you to implement a validates method.

To enable/disable a PasswordComplianceRule rule, you must create a bean in spring-config.xml, and add it to the list of beans in the masterValidator bean defintion.

For example, to add a new a new FooRule, you would create the class com.brett.PasswordComplianceService.ComplianceRule.FooRule, and add the following:

<bean id="masterValidator" class="com.brett.PasswordComplianceService.MasterValidator">
        <property name="validators">
            <list>
                <ref bean="lowerCaseAndNumericalOnlyBean"/>
                <ref bean="betweenFiveAndTwleveCharsBean"/>
                <ref bean="fooRule">
            </list>
        </property>
    </bean>
    
<bean id="lowerCaseAndNumericalOnlyBean" class="com.brett.PasswordComplianceService.ComplianceRule.LowerCaseAndNumericalOnly"/>
<bean id="betweenFiveAndTwleveCharsBean" class="com.brett.PasswordComplianceService.ComplianceRule.BetweenFiveAndTwelveChars"/>
<bean id="fooRule" class="com.brett.PasswordComplianceService.ComplianceRule.FooRule"/>
    
