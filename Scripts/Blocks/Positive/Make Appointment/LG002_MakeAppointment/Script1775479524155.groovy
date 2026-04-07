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

WebUI.selectOptionByValue(findTestObject('Page_MakeAppointment/select_Facility'), Facility, true)

WebUI.comment('User melakukan check Readmission')

//WebUI.click(findTestObject('Page_MakeAppointment/input_Apply for hospital readmission_chk_ho_9218d5'))
if (Readmission == true) {
    WebUI.check(findTestObject('Page_MakeAppointment/input_Apply for hospital readmission_chk_ho_9218d5'))
} else {
    WebUI.uncheck(findTestObject('Page_MakeAppointment/input_Apply for hospital readmission_chk_ho_9218d5'))
}

WebUI.comment('User melakukan check Programs')

//WebUI.click(findTestObject('Page_MakeAppointment/input_Medicaid_program'))
switch (Programs) {
    case 'Medicare':
        WebUI.check(findTestObject('Page_MakeAppointment/input_Medicare_program'))

        break
    case 'Medicaid':
        WebUI.check(findTestObject('Page_MakeAppointment/input_Medicaid_program'))

        break
    case 'None':
        WebUI.check(findTestObject('Page_MakeAppointment/input_None_program'))

        break
    default:
        WebUI.check(findTestObject('Page_MakeAppointment/input_None_program'))

        break
}

WebUI.click(findTestObject('Page_MakeAppointment/input_Visit_Date'))

WebUI.click(findTestObject('Object Repository/Record/MakeAppointment_Record/td_28'))

WebUI.setText(findTestObject('Page_MakeAppointment/textarea_Comment'), Comment)

//WebUI.delay(30)
WebUI.click(findTestObject('Page_MakeAppointment/button_Book Appointment'))

WebUI.comment('Sistem memverifikasi Readmission')

if (Readmission == true) {
    WebUI.verifyElementText(findTestObject('Page_AppointmentConfirmation/p_Readmission'), 'Yes')
} else {
    WebUI.verifyElementText(findTestObject('Page_AppointmentConfirmation/p_Readmission'), 'No')
}

WebUI.comment('Sistem memverifikasi Program')

select_radio = Programs
switch (select_radio) {
	case 'Medicare':
		WebUI.verifyElementText(findTestObject('Page_AppointmentConfirmation/p_Program'), Programs)

		break
	case 'Medicaid':
		WebUI.verifyElementText(findTestObject('Page_AppointmentConfirmation/p_Program'), Programs)

		break
	case 'None':
		WebUI.verifyElementText(findTestObject('Page_AppointmentConfirmation/p_Program'), Programs)

		break
	default:
		WebUI.verifyElementText(findTestObject('Page_AppointmentConfirmation/p_Program'), 'None')

		break
}

