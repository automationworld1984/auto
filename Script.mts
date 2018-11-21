'****************************************************************************************************************************************

'Script Name				: DriverScript
'Description 				: This is the driver script for execution and reporting of all test cases to be run
'Created By 				: Kumar Saurabh 
'Creation start Date		: Sep 01, 2014
'Updated By 				: Kumar SAurabh
'Updated Date 				: 
'****************************************************************************************************************************************
'To kill all the excel processes
'SystemUtil.CloseProcessByName("excel.exe")
'Call FnOutlookEmailNotification("nanda.nandyal@nbcuni.com", "kumar1.saurabh@birlasoft.com", "", "Automation Results Failed", "Test Failed as Login was not successful.")
 
 
'Window("SAFE").WinMenu("ContextMenu").Select "Data;Document Assembly;Document Assembly"
call killexcell()
'FlagLogin = SAFE_Login("SAFE_USER_NAME;SAFE_USER_PWD")
Environment("T_Start")=now

'Reset the columns for testcasefile and testplan files for new execution

'Check if report file exists or not

'If FlagLogin = True Then
	

Call CreateReportFile(FileNamewithPath)
Call CreateReportFile(failedstepdescpath)
Call CreateReportFile(Cleanup_LogFilePath)
Call HTMLRep_Open_Main_File(HTML_REPORT_OUTPUT_FILE)

Call HTMLRep_Open_Main_File(HTML_REPORT_FILE1)

failureasoncount=1
'Find out in RunOrderSheet.xls file which test cases to run
Set myxl=createobject("excel.application")
set objWorkbook=myxl.Workbooks.Open(RunOrderSheetPath)
runorder_iterationnumber=objWorkbook.Worksheets.Count
For runorder_iteration=1 to runorder_iterationnumber
	runorder_sheetname=objWorkbook.Worksheets(runorder_iteration).name
	Set objworksheet_Runorder=myxl.ActiveWorkbook.Worksheets(runorder_iteration)
	V_GLOBAL_EXCEPTION = False
	'Find out the number of test cases included in run order sheet and execute test cases that has been marked 'Y' or 'Yes' @@ hightlight id_;_853630_;_script infofile_;_ZIP::ssf62.xml_;_
	rownum_Runorder=objworksheet_Runorder.usedrange.rows.count
	For iRunorder=2 to rownum_Runorder
		If ucase(objworksheet_Runorder.cells(iRunorder,2))="Y" OR ucase(objworksheet_Runorder.cells(iRunorder,2))="YES"Then
			'retrieving testcase name that is marked 'Y' or 'yes'
			runorder_testcasename=objworksheet_Runorder.cells(iRunorder,1).value
			'capturing start time for test case
			runorder_testcasename_start_time= now
			' ** Adding a statement to load Global var lib file again, at run time
			LoadFunctionLibrary GlobalVariableFilePath ' added in SMAT_EXPORT module. Saurabh (12/24/2014)
			'***************************************************************************************************
			
			'*** Closing any pre existing SAFE instance before running application execution **** SAAURABH (UAT- 01/21/2015)
				Call killSAFE()
				SystemUtil.CloseProcessByName "cmd.exe"
                SystemUtil.Run "Y:\Application.bat"
'				SystemUtil.CloseProcessByName("safe.exe")
			'****************************************************************************************************
			'adding worksheet in failedstepdesc file for testcase to be executed
			Set myxl6 = createobject("excel.application")		
			Set objWorkbook6 = myxl6.Workbooks.Open(failedstepdescpath)
			myxl6.Worksheets.Add
			objWorkbook6.Worksheets(1).Select
			Set objworksheet6=myxl6.ActiveWorkbook.Worksheets(1)
			objWorkbook6.Worksheets(1).name=runorder_testcasename
			myxl6.ActiveWorkbook.Save
			Set objWorkbook6=nothing
			myxl6.Quit
			Set myxl6 = Nothing
			'***************************************************************************************************
			'Get the number of steps for the test case and the start position in test plan.xls file
			temparr=GetStartPos_NoofSteps(runorder_sheetname,runorder_testcasename,TestPlanPath)
			StartPos=cint(temparr(1))
			StartPos_report=StartPos
			NoofSteps=cint(temparr(2))-cint(StartPos)+1
			'Dim arrStatus()
			'ReDim arrStatus(NoofSteps)
			'Find the sheetname in testcasefile.xls file and execute the flow coded in that worksheet
			Select Case ucase(runorder_sheetname)
				Case "AIRLINE"
					TestCaseFilePath=TestCaseFilePath_Airline
				Case "GOVERNINGDEAL"
					TestCaseFilePath=TestCaseFilePath_GoverningDeal
				Case "EXECUTIVEAPPROVAL"
					TestCaseFilePath=TestCaseFilePath_ExecutiveApproval
				Case "SMAT_EA"
					TestCaseFilePath=TestCaseFilePath_SMAT_EA
				Case "AIRLINE_EA"
					TestCaseFilePath=TestCaseFilePath_AIRLINE_EA
				Case "SALESLIASONAPPROVAL"
					TestCaseFilePath=TestCaseFilePath_SALESLIASONAPPROVAL
				Case "SMAT_EXPORT"
					TestCaseFilePath=TestCaseFilePath_SMAT_EXPORT		
				Case "SECURITY"
					TestCaseFilePath=TestCaseFilePath_Security
				Case "PURCHASEORDER"
					TestCaseFilePath=TestCaseFilePath_PurchaseOrder
				Case "PRODUCT_MAINTENANCE"
					TestCaseFilePath=TestCaseFilePath_ProductMaintenance
				Case "CLEARANCE"
					TestCaseFilePath=TestCaseFilePath_Clearance
				Case "PRICING"
					TestCaseFilePath=TestCaseFilePath_Pricing
				Case "GRIDS"
					TestCaseFilePath=TestCaseFilePath_Grids
				Case "PRINTQ"
					TestCaseFilePath=TestCaseFilePath_PrintQ
				Case "REPORTFRAMEWORK"
					TestCaseFilePath=TestCaseFilePath_Report_Framework
				Case "DOCUMENTASSEMBLY"
					TestCaseFilePath=TestCaseFilePath_Document_Assembly
				Case "FIELDORDER"
					TestCaseFilePath=TestCaseFilePath_Field_Order
			    Case "TESTSUITE_MIGQA"
					TestCaseFilePath=TestCaseFilePath_TESTSUITE_MIGQA
			    Case "CATCHUP"
					TestCaseFilePath=TestCaseFilePath_Catchup		
			    Case "GMO"
					TestCaseFilePath=TestCaseFilePath_GMO
			    Case "FORECASTING_GRID"
					TestCaseFilePath=TestCaseFilePath_Forecasting_Grid
			    Case "FOLINK"
					TestCaseFilePath=TestCaseFilePath_Fo_LINK
		        Case "TICKETS"
					TestCaseFilePath=TestCaseFilePath_Tickets
		        Case "PREORDER"
					TestCaseFilePath=TestCaseFilePath_PREORDER
		        Case "RTS"
					TestCaseFilePath=TestCaseFilePath_RTS		
			    Case "GD_LETTER"
					TestCaseFilePath=TestCaseFilePath_GD_LETTER	
				Case "DATA_ADMINISTRATION"
					TestCaseFilePath=TestCaseFilePath_DATA_ADMINISTRATION
				Case "GD_REPORTS"
					TestCaseFilePath=TestCaseFilePath_GD_Reports
				Case "SUBSCRIPTION"
					TestCaseFilePath=TestCaseFilePath_SUBSCRIPTION
				Case "REPORTWIZARD"
					TestCaseFilePath=TestCaseFilePath_REPORTWIZARD
				Case "IMPORTMETADATA"
					TestCaseFilePath=TestCaseFilePath_IMPORTMETADATA
				Case "TITLEPACKAGE"
					TestCaseFilePath=TestCaseFilePath_TITLEPACKAGE	
				Case "LICENSEE"
					TestCaseFilePath=TestCaseFilePath_LICENSEE	
				Case "RIGHTS_IN_COLLISION_REPORTS"
					TestCaseFilePath=TestCaseFilePath_Rights_In_Collision_Reports
				Case "CLEARANCE_SCHEDULE_REPORTS"
					TestCaseFilePath=TestCaseFilePath_Clearance_Schedule_Reports
				Case "FO_AND_GD_CONDITIONAL_AVAIL"
					TestCaseFilePath=TestCaseFilePath_FO_and_GD_Conditional_Avail
				Case "TERRITORIES"
					TestCaseFilePath=TestCaseFilePath_TERRITORIES
				Case "TECHSPEC"
					TestCaseFilePath=TestCaseFilePath_TECHSPEC
				Case "INSIGHT_TESTCASES"
					TestCaseFilePath=TestCaseFilePath_INSIGHT
				Case "INSIGHT_TESTCASE"
					TestCaseFilePath=TestCaseFilePath_INSIGHT_TWO
				Case "TV_PRICING"
					TestCaseFilePath=TestCaseFilePath_TV_Pricing
			    Case "SMAT_STAGING"
					TestCaseFilePath=TestCaseFilePath_SMAT_STAGING

                Case "AVAIL_TRACKER"
			        TestCaseFilePath=TestCaseFilePath_Avail_Tracker
			    Case "TABLE_MAINTENANCE"
			        TestCaseFilePath=TestCaseFilePath_Table_Maintenance
				Case "METADATA_ELEMENT"
					TestCaseFilePath=TestCaseFilePath_Metadata_Elements
				Case "JAWS"
					TestCaseFilePath=TestCaseFilePath_Jaws
				Case "FO_RTS"
			        TestCaseFilePath=TestCaseFilePath_FO_RTS
                Case "NOTIFICATION_LOG"
                    TestCaseFilePath=TestCaseFilePath_Notification_Log
                Case "TITLE_STATISTICS" 
                    TestCaseFilePath=TestCaseFilePath_TITLE_STATISTICS
                Case "TITLE_METADATA" 
                    TestCaseFilePath=TestCaseFilePath_TITLE_METADATA
                Case "TRANSACTION_LOGGING_REPORTS" 
                    TestCaseFilePath=TestCaseFilePath_TRANSACTION_LOGGING_REPORTS
					
			End Select
			Set myxl1=createobject("excel.application")
			set objWorkbook1=myxl1.Workbooks.Open(TestCaseFilePath)
			numberOfSheet=objWorkbook1.Worksheets.Count
			'Find out the iteration sheet in test plan file that should match with run order sheet file
			For intsheet1 = 1 To numberOfSheet
				tempsheetname=objWorkbook1.Worksheets(intsheet1).name
				If cstr(ucase(trim(tempsheetname)))=cstr(ucase(trim(runorder_testcasename)))  Then
					Set objworksheet=myxl1.ActiveWorkbook.Worksheets(tempsheetname)
					Exit for
				End if
			next
			Set dict=createobject("scripting.dictionary")
			rownum=objworksheet.usedrange.rows.count
			'colnum=objworksheet.usedrange.columns.count
			For i=2 to rownum
				'For j=1 to colnum
				' ** Graceful Exit functionality starts here with variable: V_GLOBAL_EXCEPTION *** Saurabh (12/24/2014)
'				If V_GLOBAL_EXCEPTION = True Then
'					objworksheet.cells(i,9).value = "No Run"
'				Else
					vPBMainWindow =objworksheet.cells(i,1).value
					vPBSubWindow =objworksheet.cells(i,2).value
					vSWFWindow =objworksheet.cells(i,3).value
					vWPFWindow =objworksheet.cells(i,4).value
					objName =objworksheet.cells(i,5).value
					ObjType =objworksheet.cells(i,6).value
					ObjectType =objworksheet.cells(i,6).value
					action =ucase(objworksheet.cells(i,7).value)
					setValue =objworksheet.cells(i,8).value
					
					
					
					'calling different functions based on keywords or action to be performed on object/control
					
					Select Case action
						Case "LAUNCH_APPLICATION"
						V_GLOBAL_EXCEPTION = false
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else	
								On error resume next
								execute ("setValue1=" & setValue)
								If err.number=0 Then
								Call killSAFE()
									objworksheet.cells(i,9).value=SAFE_LaunchApplication(setValue1)
								else
								Call killSAFE()
									objworksheet.cells(i,9).value=SAFE_LaunchApplication(setValue)
								End If
								err.clear
								On error goto 0	
							End If	
						
                        

                        Case "LAUNCH_APPLICATIONMIGQA"
                         V_GLOBAL_EXCEPTION = false
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else	
								On error resume next
								execute ("setValue1=" & setValue)
								If err.number=0 Then
								Call killSAFE()
									objworksheet.cells(i,9).value=SAFE_LaunchApplicationMigQA(setValue1)
								else
								Call killSAFE()
									objworksheet.cells(i,9).value=SAFE_LaunchApplicationMigQA(setValue)
								End If
								err.clear
								On error goto 0	
							End If	
							
						Case "LOGIN_APPLICATIONMIGQA"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								'On error resume next
								objworksheet.cells(i,9).value=SAFE_MIGQALogin(setValue)
								 
								'err.clear
								'On error goto 0
							End If		
							
						Case "OPEN_APPLICATION"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								
								objworksheet.cells(i,9).value=OpenApplication(setValue)
								 
								
							End If	
							
						Case "LOGIN_APPLICATION"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								'On error resume next
								objworksheet.cells(i,9).value=SAFE_Login(setValue)
								 
								'err.clear
								'On error goto 0
							End If
							
						Case "LOGOUT_APPLICATION"
							'If V_GLOBAL_EXCEPTION = True Then
								'objworksheet.cells(i,9).value = "No Run"
							'Else
							 	objworksheet.cells(i,9).value= SAFE_Logout()
							 	'Call killSAFE()
							 	V_GLOBAL_EXCEPTION = false
							'End If	
						
						Case "LOGOUT_APPLICATIONMIGQA"
							'If V_GLOBAL_EXCEPTION = True Then
								'objworksheet.cells(i,9).value = "No Run"
							'Else
							 	objworksheet.cells(i,9).value= SAFE_LogoutMIGQA()
							 	'Call killSAFE()
							 	V_GLOBAL_EXCEPTION = false
							'End If	
						
						
						Case "CLOSE_CHILD"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
							 	objworksheet.cells(i,9).value= SAFE_CloseChildWindow(vWPFWindow)
							 End If	
						Case "CLOSE_WIN"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
							 	objworksheet.cells(i,9).value= SAFE_CloseWindow(vWPFWindow)
							 End If	
						Case "CLOSE_WPF"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								objworksheet.cells(i,9).value= SAFE_ClosePBWPFWindow(vPBMainWindow, vPBSubWindow)
							End If	
							Case "MAXIMIZE"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								objworksheet.cells(i,9).value= SAFE_Maximize(vWPFWindow)
							End If	
							
						Case "CLOSE_SWF"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								objworksheet.cells(i,9).value= SAFE_CloseDialog(vWPFWindow,objName)
							End If	
						Case "KILL_EXCELL"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
							 	objworksheet.cells(i,9).value = killexcell()
							 End If	
						Case "MAXIMIZE_CHILD"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
							 	objworksheet.cells(i,9).value= SAFE_MaximizeChildWindow(vWPFWindow)
							 End If	
						Case "SELECT_MENU"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								On error resume next
								execute ("setValue1=" & setValue)
								If err.number=0 Then
									objworksheet.cells(i,9).value=SAFE_selectmenu(setValue1)
								else
									objworksheet.cells(i,9).value=SAFE_selectmenu(setValue)
								End If
								err.clear
								On error goto 0
							End If	
							
						Case "CLICK_CONTROL"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								objworksheet.cells(i,9).value=SAFE_ClickControl(vPBMainWindow, vPBSubWindow, vSWFWindow, vWPFWindow,objName,ObjType)
							End If
						
						Case "CLICK_CONTROLCKOBJECT"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								objworksheet.cells(i,9).value=SAFE_ClickControlCKEditor(vPBMainWindow, vPBSubWindow, vSWFWindow, vWPFWindow,objName,ObjType)
							End If						
						
						Case "CLICK_CONTROLCKBUTTON"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								objworksheet.cells(i,9).value=SAFE_ClickControlCKEditorButton(vPBMainWindow, vPBSubWindow, vSWFWindow, vWPFWindow,objName,ObjType)
							End If
							
						Case "DRAG_DROP"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								objworksheet.cells(i,9).value=SAFE_DragDrop(vPBMainWindow, vPBSubWindow, vSWFWindow, vWPFWindow,objName,ObjType)
							End If
						Case "DRAG_DROP_CHILD"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								objworksheet.cells(i,9).value=SAFE_DragDrop_CHILD(vWPFWindow,objName,setValue,ObjType)
							End If
							
						Case "CLICK_CONTROL_CHILD"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								objworksheet.cells(i,9).value=SAFE_ClickControlChildWindow(vWPFWindow,objName,ObjType)
							End If
							
							Case "CLEARANCE"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								objworksheet.cells(i,9).value=SAFE_Clearance()
							End If
							
						Case "CLICK_CONTROL_CHILDCORD"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								objworksheet.cells(i,9).value=SAFE_ClickControlChildWindowcord(vWPFWindow,objName,ObjType,vPBMainWindow,vPBSubWindow)
							End If
						Case "IF_CLICK_CONTROL_CHILD"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								objworksheet.cells(i,9).value=SAFE_If_ClickControlChildWindow(vWPFWindow,objName,ObjType,vSWFWindow)
							End If
						Case "IF_CLICK_CONTROL_CHILD_MULTIPLE"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								objworksheet.cells(i,9).value=SAFE_If_ClickControlChildWindow_Multiple(vWPFWindow,objName,ObjType)
							End If
                        Case "CLICK_CONTROL_PRINT"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								objworksheet.cells(i,9).value=SAFE_ClickControlChildWindowPrint(vWPFWindow,objName,ObjType)
							End If		
                        Case "CLICK_CONTROL_CHILDSWF"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								objworksheet.cells(i,9).value=SAFE_ClickControlChildWindowswf(vWPFWindow,objName,ObjType,vSWFWindow)
							End If							
						
						Case "DOUBLECLICK_CONTROL"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								objworksheet.cells(i,9).value=SAFE_DoubleClickControl(vPBMainWindow, vPBSubWindow, vSWFWindow, vWPFWindow,objName,ObjType)
							End If
							
						Case "DOUBLECLICK_CONTROL_CHILD"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								objworksheet.cells(i,9).value=SAFE_DblClickControlChildWindow(vWPFWindow,objName,ObjType)
							End If
							
						Case "CLICK_CONTROL_POPUP"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								objworksheet.cells(i,9).value=SAFE_ClickControlPopupWindow(vPBMainWindow,vWPFWindow,objName,ObjType)	
							End If
							
							Case "CLICK_CONTROL_POPUP_SWF"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								objworksheet.cells(i,9).value=SAFE_ClickControlPopupWindow_Swf(vPBMainWindow,vWPFWindow,objName,ObjType)	
							End If
							
						Case "CLICK_CONTROL_POPUP_MIGQA"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								objworksheet.cells(i,9).value=SAFE_ClickControlPopupWindow_MIGQA(vPBMainWindow,vWPFWindow,objName,ObjType)	
							End If
							
						Case "CLICK_CONTROL_WINDOWPOPUP"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								objworksheet.cells(i,9).value=SAFE_ClickControlWindowPopupWindow(vWPFWindow,objName,ObjType)
							End If
							
'						Case "CLICK_CONTROL_WINDOWPOPUP" vDialog
'							If V_GLOBAL_EXCEPTION = True Then
'								objworksheet.cells(i,9).value = "No Run"
'							Else
'								objworksheet.cells(i,9).value=SAFE_ClickControlWindowPopupWindow(vWPFWindow,objName,ObjType)
'							End If	
'						Case "CLICK_CONTROL_SUBCHILD"
'							objworksheet.cells(i,9).value=SAFE_ClickControlChildSubWindow(vWPFWindow,objName,ObjType)
						Case "SETVALUE_CONTROL"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else	
								objworksheet.cells(i,9).value=SAFE_SetControlValue(vPBMainWindow, vPBSubWindow, vSWFWindow, vWPFWindow,objName,ObjType,setValue)
							End If
						
						Case "SETVALUE_CONTROL_CHILD"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								objworksheet.cells(i,9).value=SAFE_SetControlValueChildWindow(vWPFWindow,objName,ObjType, setValue)
								
							End If
						Case "SETVALUE"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								objworksheet.cells(i,9).value=SAFE_SetControl(vWPFWindow,objName,ObjType, setValue)
								
							End If
							Case "SETVALUE_GMO"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								objworksheet.cells(i,9).value=SAFE_SetControlValueGmo(vWPFWindow,objName,ObjType, setValue)
								
							End If
						Case "GETVALUE_CONTROL"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								objworksheet.cells(i,9).value=SAFE_GetControlvalue(vPBMainWindow, vPBSubWindow, vSWFWindow, vWPFWindow,objName,ObjType,setValue)
							End If
							
						Case "GETVALUE_CONTROL_CHILD"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								objworksheet.cells(i,9).value=SAFE_GetControlValueChild(vWPFWindow,objName,ObjType, setValue)
							End If
							
							
						Case "VERIFYCELL_DATA"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								objworksheet.cells(i,9).value=SAFE_VerifyCellData(vPBMainWindow, vPBSubWindow, vSWFWindow, vWPFWindow,objName,ObjType,setValue)
							End If
						
						Case "VERIFYCELL_DATA_CHILD" 
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								objworksheet.cells(i,9).value = SAFE_VerifyCellDataChildChild(vWPFWindow,objName,ObjType,setValue)
							End If
							
						Case "EXISTS_CONTROL"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								objworksheet.cells(i,9).value=SAFE_isExistsControl(vPBMainWindow, vPBSubWindow, vSWFWindow, vWPFWindow,objName, ObjType, minTime, maxTime)
							End If
						
						Case "NOT_EXISTS_CONTROL"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								objworksheet.cells(i,9).value=SAFE_NotExistsControl(vPBMainWindow, vPBSubWindow, vSWFWindow, vWPFWindow,objName, ObjType, minTime, maxTime)
							End If
						
						Case "EXISTS_CONTROL_CHILD"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
 								objworksheet.cells(i,9).value=SAFE_IsExistsControlChildWindow(vWPFWindow,objName,ObjType,minTime, maxTime)
							End If
						
						Case "EXISTS_IF"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								objworksheet.cells(i,9).value=SAFE_IfExist(vWPFWindow,objName,ObjType,minTime,maxTime)
							End If
							
						Case "EXISTS"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								objworksheet.cells(i,9).value=SAFE_IsExists(vPBMainWindow,vWPFWindow,objName,ObjType,minTime,Htime)
							End If	
                        Case "EXISTS_CONTROL_CHILDSWF"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								objworksheet.cells(i,9).value=SAFE_IsExistsControlChildWindowswf(vWPFWindow,objName,ObjType,minTime, Htime,vSWFWindow)
							End If							
								
						Case "NOT_EXISTS_CONTROL_CHILD"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								objworksheet.cells(i,9).value=SAFE_NotExistsControlChild(vWPFWindow,objName, ObjType, minTime,maxTime_C)
							End If
							
						Case "VERIFY_TEXT_CONTROL"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								objworksheet.cells(i,9).value=SAFE_VerifyTextOfControl(vPBMainWindow, vPBSubWindow, vSWFWindow, vWPFWindow,objName,ObjType,setValue)
							End If
						Case "dragANDdROP"
						If V_GLOBAL_EXCEPTION = True Then
							objworksheet.cells(i,9).value = "No Run"
							Else
							objworksheet.cells(i,9).value=SAFE_dragAndDrop()
							
						End If
						      
						
						Case "VERIFY_TEXT_CONTROL_CHILD"	
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else						
								objworksheet.cells(i,9).value=SAFE_VerifyTextOfControlChild(vWPFWindow,objName,ObjType,setValue)
							End If	
						
						
						
						Case "OVERRIDE"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								objworksheet.cells(i,9).value=SAFE_OVERRIDE(vWPFWindow,minTime,maxTime)
							End If
						
						
						Case "SENDKEYS"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								On error resume next
								execute ("setValue1=" & setValue)
								If err.number=0 and setValue1 <> empty Then
									setValue=setValue1
								End If
								ERR.CLEAR
								On error goto 0
								objworksheet.cells(i,9).value=SAFE_sendkeys(setValue)
							End If
							
							Case "SAFE_GET_TEXT"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								
								objworksheet.cells(i,9).value=SAFE_GetText()
							End If
							
					
						Case "WAIT"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								objworksheet.cells(i,9).value=MV_wait(setvalue)
							End If
							
						Case "OUTPUT"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								checkoutput=split(setvalue,",")
								objworksheet.cells(i,9).value=objworksheet.cells(i-checkoutput(0),9).value
								objworksheet.cells(i+checkoutput(1),6).value=objworksheet.cells(i-checkoutput(0),9).value
							End If
							
						Case "TRIM"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								objworksheet.cells(i,9).value=trim(objworksheet.cells(setValue,9).value)
							End If
							
						Case "CLEANUP_LOGFILE"
							objworksheet.cells(i,9).value=MV_Cleanup_LogFile(setValue)
						Case "MID"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								midsplit=split(setValue,",")
								strexpression=objworksheet.cells(midsplit(0),9).value
								strstart=midsplit(1)
								objworksheet.cells(i,9).value=mid(strexpression,strstart)
							End If
							
						Case "LEFT"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								midsplit=split(setValue,",")
								strexpression=objworksheet.cells(midsplit(0),9).value
								strEnd=midsplit(1)
								objworksheet.cells(i,9).value=Left(strexpression,strEnd)
							End If
							
						Case "EVAL"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								evalsplit=split(setValue,",")
								evalexpression1=objworksheet.cells(evalsplit(0),9).value
								evalexpression2=objworksheet.cells(evalsplit(1),9).value
								
								objworksheet.cells(i,9).value=eval_expression(evalexpression1, evalexpression2)
							End If
							
							
							
						Case "NOTEQL"
						If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
							
							evalsplit=split(setValue,",")
								evalexpression1=objworksheet.cells(evalsplit(0),9).value
								evalexpression2=objworksheet.cells(evalsplit(1),9).value
								
								
								objworksheet.cells(i,9).value=eval_notequal(evalexpression1, evalexpression2)
							End If
						
						Case "DEFINEA"
						If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
							data1 = setValue
							End If
							
						Case "DEFINEB"
						If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
							data2 = setValue
							End If
							
						Case "REPLACE"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								repsplit=split(setValue,",")
								repexpression=objworksheet.cells(repsplit(0),9).value
								If ucase(repsplit(2))="BLANK" Then
									repsplit(2)=""
								End If
								repstring= replace(repexpression,repsplit(1),repsplit(2))
								objworksheet.cells(i,9).value=repstring
							End If
							
						Case "CONCATENATE"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								'split for getting row no and delimiter
								objworksheet.cells(i,9).value=""
								splitsetval1=split(setValue,";")
								'split for row no
								splitsetval2=split(splitsetval1(0),",")
								For each val1 in splitsetval2
									objworksheet.cells(i,9).value=trim(objworksheet.cells(i,9).value&splitsetval1(1)&objworksheet.cells(val1,9).value)
								Next
								objworksheet.cells(i,9).value=Mid(objworksheet.cells(i,9).value,3)
	'							If splitsetval1(1)<>" " Then
	'								objworksheet.cells(i,9).value=replace(objworksheet.cells(i,9).value,splitsetval1(1),"",1,1)
	'							End If
							End If
							
						Case "CLIPBOARD_OPERATION"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								evalsplit=split(setValue,",")
								Clipexpression1=evalsplit(0)
								Clipexpression2=evalsplit(1)
								
								objworksheet.cells(i,9).value=ClipboardOperation(Clipexpression1,Clipexpression2)
							End If

                    Case "LAUNCH_APPLICATION_INSIGHT"
                         V_GLOBAL_EXCEPTION = false
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else	
								On error resume next
								execute ("setValue1=" & setValue)
								If err.number=0 Then
								Call killSAFE()
									objworksheet.cells(i,9).value=SAFE_LaunchApplication_Insight(setValue1)
								else
								Call killSAFE()
									objworksheet.cells(i,9).value=SAFE_LaunchApplication_Insight(setValue)
								End If
								err.clear
								On error goto 0	
							End If	
							
							Case "LOGIN_INSIGHT"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								'On error resume next
								objworksheet.cells(i,9).value=SAFE_Login_Insight(setValue)
								 
								'err.clear
								'On error goto 0
							End If

                      Case "SAFE_GRIDS"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								
								objworksheet.cells(i,9).value=SAFE_Grids()
								 
							End If
							
						Case "SAFE_APPROVAL"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								
								objworksheet.cells(i,9).value=SAFE_APPROVAL()
								 
							End If
							
                       Case "LOGIN_APPLICATION_INSIGHT"
							If V_GLOBAL_EXCEPTION = True Then
								objworksheet.cells(i,9).value = "No Run"
							Else
								'On error resume next
								objworksheet.cells(i,9).value=SAFE_ApplicationLogin_Insight(setValue)
								 
								'err.clear
								'On error goto 0
							End If		
							
						Case "LOGOUT_APPLICATION_INSIGHT"
							'If V_GLOBAL_EXCEPTION = True Then
								'objworksheet.cells(i,9).value = "No Run"
							'Else
							 	objworksheet.cells(i,9).value= SAFE_Logout_Insight()
							 	'Call killSAFE()
							 	V_GLOBAL_EXCEPTION = false
							'End If	
							
						Case "FLAG"
							flag_startpos=2
							For flag_prev=i-1 to 2 step -1
								if ucase(objworksheet.cells(flag_prev,7).value)=action then
									flag_startpos=flag_prev+1
									Exit for
								End if					
							Next
							For flag_i=flag_startpos to i-1
								If ucase(objworksheet.cells(flag_i,9).value)="TRUE"  Then
'								If objworksheet.cells(flag_i,9).value <> empty Then
'									If ucase(objworksheet.cells(flag_i,9).value)<>"FALSE" Then
										stepno=stepno+1
										dict.Add "stepno"&stepno,"true"
										If flag="false" Then
										
										else
											flag="true"	
										End If
'									End If	
								ElseIf ucase(objworksheet.cells(flag_i,9).value)="NO RUN" Then
										stepno=stepno+1
										dict.Add "stepno"&stepno,"no run"
										If flag="false" Then
										
										else
											flag="No Run"	
										End If
										
										'Exit for
								ElseIf ucase(objworksheet.cells(flag_i,9).value)=empty Then
										stepno=stepno+1
										dict.Add "stepno"&stepno,"not completed"
										If flag="false" Then
										
										else
											flag="not completed"	
										End If
										'Exit for
								ElseIf ucase(objworksheet.cells(flag_i,9).value)="FALSE" Then
									stepno=stepno+1
									dict.Add "stepno"&stepno,"false"
									flag="false"
'									Exit for
									'***************************************************************************************************
									Set myxl6 = createobject("excel.application")		
									Set objWorkbook6 = myxl6.Workbooks.Open(failedstepdescpath)
									objWorkbook6.Worksheets(1).Select
									Set objworksheet6=myxl6.ActiveWorkbook.Worksheets(1)
									rownum_failedstep2=objworksheet6.usedrange.rows.count
									For i_failedstep2=2 to rownum_failedstep2
										If objworksheet6.cells(i_failedstep2,2).value=flag_i Then
											If Actual="" Then
												Actual="(" & failureasoncount & ")" & objworksheet6.cells(i_failedstep2,1).value
											else
												Actual=Actual & " " & "(" & failureasoncount & ")" & objworksheet6.cells(i_failedstep2,1).value
											End If
											failureasoncount=failureasoncount+1
											Exit for
										End If
									Next							
									myxl6.ActiveWorkbook.Save
									Set objWorkbook6=nothing
									myxl6.Quit
									Set myxl6 = Nothing
								'***************************************************************************************************
								

								End If
							
							Next
'							End Select
	'						End If
							failureasoncount=1
							objworksheet.cells(i,9).value=flag
							If flag= "true" Then
							    objworksheet_Runorder.cells(iRunorder,2)="n"
							    objworksheet_Runorder.cells(iRunorder,3)="Pass"
								call UpdateTestPlan(runorder_sheetname,StartPos,"As expected","Pass",TestPlanPath)
							ElseIf flag= "false" Then
							   
								call UpdateTestPlan(runorder_sheetname,StartPos,Actual,"Fail",TestPlanPath)
								 objworksheet_Runorder.cells(iRunorder,2)="y"
								 objworksheet_Runorder.cells(iRunorder,3)="Fail"
								Actual=""
	'								call UpdateTestPlan(runorder_sheetname,StartPos,"Not working as expected","Fail",TestPlanPath)
							ElseIf Ucase(flag)="NO RUN" Then
								call UpdateTestPlan(runorder_sheetname,StartPos,"Test step is not completed","No Run",TestPlanPath)
								objworksheet_Runorder.cells(iRunorder,2)="y"
								 objworksheet_Runorder.cells(iRunorder,3)="Fail"
								
							else
								call UpdateTestPlan(runorder_sheetname,StartPos,"Not working as expected","Fail",TestPlanPath)
								objworksheet_Runorder.cells(iRunorder,2)="y"
								 objworksheet_Runorder.cells(iRunorder,3)="Fail"
							End If					
							stepno=stepno+1
							StartPos=StartPos+1
						'End If
						End Select
						flag=empty
					'End If	
					
					'***************************************************************************************************
					If objworksheet.cells(i,8).value<> empty Then
						conditionsplit=split(objworksheet.cells(i,8).value,"=")
						If lcase(conditionsplit(0))="goto" Then
							If ucase(objworksheet.cells(i,9).value)="TRUE" Then
								For i_conditionsplit =i+1 to rownum
									If objworksheet.cells(i_conditionsplit,8).value<>empty Then
										conditionsplit2=split(objworksheet.cells(i_conditionsplit,8).value,"=")
										If ucase(conditionsplit(1))=ucase(conditionsplit2(1)) Then
											i=i_conditionsplit-1
											Exit for
										End If
									End If
								Next
							End If
						End If
					End If
					'***************************************************************************************************
					'***************************************************************************************************
					If action<>"FLAG" Then
						If ucase(objworksheet.cells(i,9).value)="FALSE" Then
							Set myxl5 = createobject("excel.application")		
							Set objWorkbook5 = myxl5.Workbooks.Open(failedstepdescpath)
							objWorkbook5.Worksheets(1).Select
							Set objworksheet5=myxl5.ActiveWorkbook.Worksheets(1)
							rownum_failedstep=objworksheet5.usedrange.rows.count
							For i_failedstep=2 to rownum_failedstep
								If objworksheet5.cells(i_failedstep,2).value=empty Then
									objworksheet5.cells(i_failedstep,2).value=i
									Exit for
								End If
							Next							
							myxl5.ActiveWorkbook.Save
							Set objWorkbook5=nothing
							myxl5.Quit
							Set myxl5 = Nothing
						End If
					End If
					'***************************************************************************************************
				'Next
			Next
			myxl1.ActiveWorkbook.Save
			myxl1.Workbooks.Close
			myxl1.Quit
			Set objworksheet=nothing
			Set myxl1=nothing
			runorder_testcasename_end_time=now
			s1=datepart("s",runorder_testcasename_start_time)
			s2=datepart("s",runorder_testcasename_end_time)
			runorder_testcasename_execution_time = datediff("n",runorder_testcasename_start_time,runorder_testcasename_end_time) & " min "
			'update report for test case details
			call WriteStepInWorkSheet(runorder_testcasename,runorder_sheetname,StartPos_report,NoofSteps,FileNamewithPath)
			Call createSummaryReport(FileNamewithPath)
			'***************************************************************************************************
			'update testcase execution time in report
			Set myxl11 = createobject("excel.application")
			Set objWorkbook11 = myxl11.Workbooks.Open(FileNamewithPath)
			objWorkbook11.Worksheets("Index").Select
			getRowNumber11=objWorkbook11.Worksheets("Index").UsedRange.Rows.count
			For i11=2 to getRowNumber11
				If objWorkbook11.Worksheets("Index").Cells(getRowNumber11,1).Value=runorder_testcasename Then
					objWorkbook11.Worksheets("Index").Cells(getRowNumber11,4).Value=runorder_testcasename_start_time
					objWorkbook11.Worksheets("Index").Cells(getRowNumber11,5).Value=runorder_testcasename_end_time
					objWorkbook11.Worksheets("Index").Cells(getRowNumber11,3).NumberFormat = "[h]:mm:ss;@"
					objWorkbook11.Worksheets("Index").Cells(getRowNumber11,3).Value="=RC[2]-RC[1]"'runorder_testcasename_execution_time
					objWorkbook11.Worksheets("Index").Cells(getRowNumber11,4).Font.Color = vbWhite
					objWorkbook11.Worksheets("Index").Cells(getRowNumber11,5).Font.Color = vbWhite
					objWorkbook11.Worksheets("Index").Cells(getRowNumber11,6).Value=runorder_sheetname
					objWorkbook11.Worksheets("Index").Cells(getRowNumber11,6).Font.Color = vbWhite
					Exit for
				End If
			Next
			myxl11.ActiveWorkbook.Save
			myxl11.Quit
			Set objWorkbook11=nothing
			Set myxl11=nothing
			'***************************************************************************************************
		End If
	Next
	If V_GLOBAL_EXCEPTION = True  Then
		If PbWindow(vPBMainWindow).Exist(minTime) Then
			Call SAFE_Logout()
		End If
	End If
	'arrStatus()= empty
Next
objWorkbook.Save
myxl.Quit
Set objworksheet_Runorder=nothing
Set myxl=nothing
'Create summary report in report file
SystemUtil.CloseProcessByName "cmd.exe"
Call createSummaryReport(FileNamewithPath)
Call FnHTML_Report_Index(HTML_REPORT_FILE3, FileNamewithPath)
'Call HTMLRep_Close
Call FnGenerateOutputHTMLFile(HTML_REPORT_OUTPUT_FILE)

Call HTMLRep_Show_Result(HTML_REPORT_OUTPUT_FILE)



'*** To Send Using Outlook, uncomment below function. ***'
'Call FnAttachHTMLAsMailContent(MAIL_TO, MAIL_CC, "","SAFE Release: " &TEST_RELEASE& ", Test Automation Results/ RUN Name: " &Environment.Value("ScenarioId"), HTML_REPORT_OUTPUT_FILE)

'*** Function To Send Using GMAIL below, uncomment below function. ***'
'Call FnGmail_CDO_Notification(MAIL_TO, MAIL_CC, "","SAFE Release: " &TEST_RELEASE& ", Test Automation Results/ RUN Name: " &Environment.Value("ScenarioId"), HTML_REPORT_OUTPUT_FILE)

'Window("SAFE").WinMenu("Menu").Select "Master Data;Title Entry - Series"

'PbWindow("SAFE_MainWindow").PbWindow("POL_List").SwfObject("POL_ElementHost1").WpfWindow("POL_WpfWindow").WpfObject("POL_Flag").Click 313,15 @@ hightlight id_;_1968733220_;_script infofile_;_ZIP::ssf150.xml_;_
 @@ hightlight id_;_1968733220_;_script infofile_;_ZIP::ssf153.xml_;_
'WPFWindow("Clause & Form Maintenance").WpfObject("Merge Fields").Click @@ hightlight id_;_1941822100_;_script infofile_;_ZIP::ssf246.xml_;_

'WpfWindow("Clause & Form Maintenance").WpfObject("Merge Fields").Click 19,3 @@ hightlight id_;_1896170452_;_script infofile_;_ZIP::ssf255.xml_;_
'vWPFWindow= "Clause & Form Maintenance"
'objName= "Merge Fields"
' @@ hightlight id_;_1884252716_;_script infofile_;_ZIP::ssf273.xml_;_
'WpfWindow("Title Maintenance List").WpfObject("TM_GLAccNumber").Click
'wait 5
'SAFE_GL_ACNUM="TV" & Left(Left(replace(date(),"/",""),4) & Replace(Formatdatetime(Time(),4),":",""),8)
'
'Set osend=createobject("wscript.shell")
'	osend.sendkeys SAFE_GL_ACNUM
'	wait 5
'vWPFWindow="Title Maintenance List"
'objName="TM_Prodnum"
'ObjType="WpfObject"
'b=SAFE_ClickControlChildWindow(vWPFWindow,objName,ObjType) @@ hightlight id_;_2081354308_;_script infofile_;_ZIP::ssf489.xml_;_
'wait 5
'a= "12345"
'Set osend=createobject("wscript.shell")
'	osend.sendkeys a
'	wait 5
'a= "12345"

'ObjType ="PC"
'a=SAFE_ClickControlChildWindowswf(vWPFWindow,objName,ObjType,vSWFWindow) @@ hightlight id_;_1971805076_;_script infofile_;_ZIP::ssf567.xml_;_
'
' @@ hightlight id_;_1971728252_;_script infofile_;_ZIP::ssf569.xml_;_
'On Error Resume Next
'
'WpfWindow("Sales & Avail Reports_4").SwfObject("SwfObject").SwfButton("Product Categorization").Click @@ hightlight id_;_55968156_;_script infofile_;_ZIP::ssf570.xml_;_
'
'msgbox timer
'WpfWindow("SAFEMigration_QA").WpfObject("Master Data").Exist
'
'msgbox Err.descriptions @@ hightlight id_;_2084441380_;_script infofile_;_ZIP::ssf690.xml_;_
'a="{RIGHT 12}"
'WpfWindow("Field Order List").WpfObject("Type_Of_Letter").Click @@ hightlight id_;_2112958120_;_script infofile_;_ZIP::ssf751.xml_;_
'wait 5
' Set osend=createobject("wscript.shell")
' osend.sendkeys a
' WAIT 10
 @@ hightlight id_;_2050487852_;_script infofile_;_ZIP::ssf753.xml_;_
 @@ hightlight id_;_2081431240_;_script infofile_;_ZIP::ssf761.xml_;_
 @@ hightlight id_;_2093556340_;_script infofile_;_ZIP::ssf771.xml_;_
 @@ hightlight id_;_2031974932_;_script infofile_;_ZIP::ssf773.xml_;_
' @@ hightlight id_;_788650_;_script infofile_;_ZIP::ssf783.xml_;_
' @@ hightlight id_;_1998246352_;_script infofile_;_ZIP::ssf785.xml_;_
' @@ hightlight id_;_1899465828_;_script infofile_;_ZIP::ssf788.xml_;_
'WpfWindow("My Favorites").WpfObject("Report_SalesAvail").Click 94,15 @@ hightlight id_;_1899312956_;_script infofile_;_ZIP::ssf792.xml_;_
' @@ hightlight id_;_1899459620_;_script infofile_;_ZIP::ssf789.xml_;_
'wait 1
'Set osend=createobject("wscript.shell")
' osend.sendkeys "{TAB 3}"
' WAIT 3
'WpfWindow("Clearance Schedule Reports").WpfObject("Features_without_a_US_Theatrical_Rel_Dt_report").Click 126,10 @@ hightlight id_;_2119615308_;_script infofile_;_ZIP::ssf791.xml_;_
' @@ hightlight id_;_1899466604_;_script infofile_;_ZIP::ssf790.xml_;_
'iReturn = 


'a=SAFE_LaunchApplication_New()



'SAFE_BUILD_PATH="D:\RTSQA"
'
'A=SAFE_LaunchApplication_Insight(SAFE_BUILD_PATH)
'
'UID="username_sso;password_sso"
'b=SAFE_Login_Insight(UID)
'msgbox A
'msgbox b
''************************************************************
'SAFE_BUILD_PATH="D:\RTSQA"
'username_sso = "tfayd\206484872"
'password_sso = "Jul1234jul"
'SAFE_USER_NAME="testuser2"
'SAFE_USER_PWD="pa$$word10"
'a= SAFE_LaunchApplication_Insight(SAFE_BUILD_PATH)
'b=SAFE_Login_Insight("username_sso;password_sso")
'c=SAFE_ApplicationLogin_Insight("SAFE_USER_NAME;SAFE_USER_PWD")
'vWPFWindow="RTS QA"
'objName="Browse"
'ObjType="InsightObject"
'
'A=SAFE_ClickControlChildWindow(vWPFWindow,objName,ObjType)
'MSGBOX A
'Window("RTS QA").InsightObject("GD_DealName").DblClick
'wait 2
'a="{End}"
'
'x=SAFE_sendkeys(a)
'x=SAFE_sendkeys(a)
'wait 2
'b="+{A}"
'y=SAFE_sendkeys(b)
'y=SAFE_sendkeys(b)
'wait 2
'c="{DEL}"
'b="2"
'z=SAFE_sendkeys(c)
'z=SAFE_sendkeys(c)
'wait 2-
'abc= "testdata1234"

'
'a=WpfWindow("Field Order List").InsightObject("InsightObject").GetVisibleText()
'msgbox a
'Window("RTS QA [1LI]_3").InsightObject("SU_Amin_ddlToUser").Click
'Window("RTS QA [1LI]_3").InsightObject("SU_Amin_ddlToUser").Click
'wait 2
'COPY_FROM = "TestLastName3, TestFirstName3"
'a=Window("RTS QA [1LI]_3").InsightObject("SU_Amin_ddlToUser").g
'msgbox a

'c="{ENTER}"
'z=SAFE_sendkeys(c)
'a="1"
'killSAFE()
 @@ hightlight id_;_2079054704_;_script infofile_;_ZIP::ssf910.xml_;_
 @@ hightlight id_;_2124684408_;_script infofile_;_ZIP::ssf911.xml_;_
 @@ hightlight id_;_1939774776_;_script infofile_;_ZIP::ssf975.xml_;_
 @@ hightlight id_;_1_;_script infofile_;_ZIP::ssf953.xml_;_

'WpfWindow("Field Order List").WpfButton("Grid Preference").Set "On" @@ hightlight id_;_2092777224_;_script infofile_;_ZIP::ssf960.xml_;_
'WpfWindow("Field Order List").WpfButton("Options").Set "On" @@ hightlight id_;_2092791864_;_script infofile_;_ZIP::ssf961.xml_;_
'wait 2 @@ hightlight id_;_2047300564_;_script infofile_;_ZIP::ssf969.xml_;_
'WpfWindow("Field Order List").WpfObject("rsZoom").Click 4,10 @@ hightlight id_;_2047300564_;_script infofile_;_ZIP::ssf971.xml_;_
'WpfWindow("Field Order List").WpfObject("rsZoom").Set 0.400000 @@ hightlight id_;_2047300564_;_script infofile_;_ZIP::ssf972.xml_;_
' SAFE_ClickControlChildWindow(vWPFWindow, objName, ObjectType)



