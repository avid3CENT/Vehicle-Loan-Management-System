# Vehicle-Loan-Management-System

My first project on creating a common Vehicle Loan Management Application for both Customers and Bank Employees with functions as below:

***As a Customer***:
1.  Can Register (with limited information)/Sign in
2.  Can add additional mandatory information for applying for Car Loan
3.  Can view all Loan options, calculate EMI and apply for a Car Loan
4.  Monitor the status of his/her Car Loan Application
5.  Pay Loan EMI

***As a Bank Manager***:
1.  Can view Car Loan applications
2.  Can Approve/Reject Car Loan applications
3.  Can View/Modify Loans
4.  Can view information of Bank customers individually
5.  Can View Approved Loan applications status 

***As a Bank Employee***
1.  Can ONLY view Loan applications
2.  Can view information of Bank customers individually
3.  Can ONLY view Loan features
4.  Can View Approved Loan status

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Pre-Requisites to run the application:

* I worked on Eclipse 2020-06 version. An Eclipse IDE will be recommended.
* Oracle 11g SQL plus
* Java JDK 8 or above if released
* Jar files included in this project
* Make Databases as mentioned below :

**Create Tables as mentioned**

=============================================
EMPLOYEE
=============================================
Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 EMP_ID                                    NOT NULL NUMBER(6)
 EMP_NAME                                  NOT NULL VARCHAR2(30)
 EMP_USERNAME                              NOT NULL VARCHAR2(30)
 EMP_PASSWORD                              NOT NULL VARCHAR2(30)
 EMP_JOB                                   NOT NULL VARCHAR2(20)

============================================
CUSTOMER
============================================
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 CUS_ID                                    NOT NULL NUMBER(6)
 CUS_NAME                                  NOT NULL VARCHAR2(30)
 CUS_CONTACT                               NOT NULL VARCHAR2(10)
 CUS_SALARY                                         FLOAT(8)
 CUS_USERNAME                              NOT NULL VARCHAR2(30)
 CUS_PASSWORD                              NOT NULL VARCHAR2(30)
 CUS_AADHAR                                         VARCHAR2(12)
 CUS_BANKACC                                        VARCHAR2(15)
 CUS_PAN                                            VARCHAR2(20)
 CUS_VEHICLE                                        VARCHAR2(30)
 CUS_OCC                                            VARCHAR2(20)

==============================================
CUSTADDRESS
==============================================
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 CUS_ID                                             NUMBER(6)
 HOUSE_NO                                  NOT NULL VARCHAR2(30)
 BUILDING                                  NOT NULL VARCHAR2(30)
 PLACE                                     NOT NULL VARCHAR2(30)
 CITY                                      NOT NULL VARCHAR2(30)
 STATE                                     NOT NULL VARCHAR2(30)
 PIN                                                VARCHAR2(7)

================================================
LOAN
================================================
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 LOAN_ID                                   NOT NULL NUMBER(3)
 LOAN_NAME                                 NOT NULL VARCHAR2(20)
 LOAN_TYPE                                 NOT NULL VARCHAR2(15)
 LOAN_RATE                                 NOT NULL VARCHAR2(10)
 LOAN_TERM                                 NOT NULL NUMBER(3)
 LOAN_DOWNPAY                              NOT NULL FLOAT(9)
 LOAN_PRINCIPAL                            NOT NULL VARCHAR2(40)

=================================================
APPLICATION
=================================================

 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 APP_ID                                    NOT NULL NUMBER(4)
 CUS_ID                                    NOT NULL NUMBER(6)
 CUS_NAME                                  NOT NULL VARCHAR2(30)
 LOAN_ID                                   NOT NULL NUMBER(3)
 LOAN_NAME                                 NOT NULL VARCHAR2(20)
 PRINCIPAL                                 NOT NULL FLOAT(9)
 RATE                                      NOT NULL FLOAT(4)
 TERM                                      NOT NULL NUMBER(3)
 STATUS                                    NOT NULL VARCHAR2(10)
 CAR_NAME                                  NOT NULL VARCHAR2(20)
 CAR_TYPE                                  NOT NULL VARCHAR2(20)
 LOAN_DOWNPAY                              NOT NULL FLOAT(6)

=================================================
STATUS
=================================================

Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 APP_ID                                    NOT NULL NUMBER(4)
 CUS_ID                                    NOT NULL NUMBER(6)
 LOAN_ID                                   NOT NULL NUMBER(3)
 PRINCIPAL                                 NOT NULL FLOAT(9)
 RATE                                      NOT NULL FLOAT(4)
 TERM                                      NOT NULL NUMBER(3)
 EMI                                                FLOAT(9)
 LAST_MONTH_EMI_PAID                                VARCHAR2(3)
 TOTAL_PAID_BACK                                    FLOAT(9)
 TERM_LEFT                                          NUMBER(3)
 TOTAL_PAYABLE_AMOUNT                               FLOAT(9)
 TOTAL_PAYABLE_LEFT                                 FLOAT(9)





















