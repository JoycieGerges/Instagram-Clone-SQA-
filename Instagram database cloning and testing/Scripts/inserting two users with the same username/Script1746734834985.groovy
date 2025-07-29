import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
//
import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import java.nio.file.Files
import java.nio.file.Paths
def filePath = "C:/Users/lamis/Desktop/Test/test_results.json"

// تحميل البيانات الحالية
def file = new File(filePath)
def data = []

if (file.exists() && file.text.trim()) {
	data = new JsonSlurper().parseText(file.text)
}

// إضافة نتيجة جديدة
data << ["name": "Add 2 users with the same user name", "status": "Faild"]

// حفظ الملف
file.text = JsonOutput.prettyPrint(JsonOutput.toJson(data))
// Test Case: Insert Two Users With Same Username
'Start the test case'
def username = 'duplicate_user'
def email = 'user@example.com'
def password = 'test123'

'Connect to the database'
WebUI.openBrowser('')

'Insert the first user'
def insertUserQuery1 = "INSERT INTO users (username, email, password) VALUES ('${username}', '${email}', '${password}')"
def result1 = executeSQL(insertUserQuery1)

'Insert the second user with the same username'
def insertUserQuery2 = "INSERT INTO users (username, email, password) VALUES ('${username}', 'user2@example.com', '${password}')"
def result2 = executeSQL(insertUserQuery2)

'Check the result of the query'
assert result2 == "Error: Username must be unique"
