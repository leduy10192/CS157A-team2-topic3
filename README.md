# eTRT System
Final Project for CS157A Fall 2019

**eTRT** is a Java Application for PC.

Group2: **Duy Le, Ivan Hernandez, Theron Myers**


## Problem Statement

eTRT is a system that supports data transactions at a hypothetical small/medium clinic specializes in 
tinnitus retraining therapy (TRT) for the management of hearing disorders. It requires an application to 

- [x] collect the patient’s questionnaire information and a database to store the gathered data at the end of patient visits.
- [x] The Application must have a GUI for adding patient visits
- [x] a GUI for filling out Tinnitus Handicap Inventory (THI) form and Tinnitus Functional Index (TFI) form. 
- [x] The application also calculated the total scores, sub-scores and level of severity from each form. 

The database must be well set up and able to handle data queries and updates effectively.

The full functional requirements are specified in:

https://github.com/tarnowska/eTRT-analysis-git/blob/master/functional-specification.pdf

## High level architecture of system : 2-tier architecture. 
- Java application talks directly through the data source using a JDBC driver. 
- User’s commands are sent to the data source, which is a MySQL database installed locally 

## Technologies used: 
- Java 8, MySQL DB 5.7, Java Netbeans IDE 

## Technical Reports and Configuration:  
- Please read file: TechnicalReports.pdf

## License

    Copyright [2019] [Duy Le, Ivan Hernandez, Theron Myers]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
