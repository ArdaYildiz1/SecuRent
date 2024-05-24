# SecuRent
SecuRent is an application which enhances the house rental process as well as addressing the issues that are related with the house rental process. SecuRent application emerges as a pioneering solution designed to transform the dynamics between tenants and landlords. With SecuRent, tenants can request officials (who are assigned by the government) to determine the rental price of  a house, if they are not in favor of the price set by the landlord. Thus, ballooned prices set by the landlords can be regulated by the officials to prevent tenants paying more than what is worth for a particular house. Furthermore, if a house is rented, the status of the house will be updated in the application and a contract uploaded by the landlord will enable the government to monitor the contract. Moreover, with SecuRent, the deposit money for houses will be collected at the government treasury. 
* Access the web page of the SecuRent: https://yusufsenyuz.github.io/Project-Web-Page/#summary

# Technologies Used
* Frontend: React.js, Bootstrap
* Backend: Spring Boot, PostgreSQL

# Prerequisites
* Node.js and npm: Ensure that Node.js and npm (Node Package Manager) are installed on your system. You can download them from nodejs.org.

* Java Development Kit (JDK): Install the appropriate version of the JDK for your project. You can download it from Oracle or use OpenJDK.

* Maven: Maven is used for managing the project's build lifecycle. Install Maven by following the instructions on the official Apache Maven website.
General:

* Git: Make sure Git is installed on your system to clone the project repository. You can download Git from git-scm.com.

* Code Editor: Choose a code editor of your preference, such as Visual Studio Code, IntelliJ IDEA, Eclipse, etc.

# Getting Started
Please follow the steps below to setup the project and have a running application eventually.

# Frontend
* Clone the repository: git clone https://github.com/ArdaYildiz1/SecuRent.git
* Navigate to the frontend directory: cd frontend
* Install dependencies: npm install
* Start the development server: npm start

# Backend
* Clone the repository: git clone https://github.com/ArdaYildiz1/SecuRent.git
* Navigate to the backend directory: cd backend
* Install dependencies: mvn install
* Run the Spring Boot application: mvn spring-boot:run
```md
```md
# User Manual

The SecuRent is an application which enhances the house rental process as well as addressing the issues that are related with the house rental process. SecuRent application emerges as a pioneering solution designed to transform the dynamics between tenants and landlords. With SecuRent, tenants can request officials (who are assigned by the government) to determine the rental price of a house if they are not in favor of the price set by the landlord. Thus, ballooned prices set by the landlords can be regulated by the officials to prevent tenants paying more than what is worth for a particular house. Furthermore, if a house is rented, the status of the house will be updated in the application and a contract uploaded by the landlord will enable the government to monitor the contract. If a landlord wants to increase the rent price before the contract expiration date, the government will be notified with a request. Hence, the rent prices will not be increased without the government's consent, ultimately preventing unwanted skyrocketing prices that cause hardships for tenants. Moreover, with SecuRent, the deposit money for houses will be collected at the government treasury. The implication of this use case is that the deposit money will be given to either the tenant or the landlord depending on the condition of the house after the contract expires. Thus, conflicts between tenants and landlords caused by deciding who will keep the deposit money will be solved, as the government will act as the mediator in this process.

## Tenant

### Step-by-Step Guide

1. **Log In:**
    - Open the login page.
    - Enter your credentials (username and password).
    - Click the "Log In" button.

2. **View Rented House Information:**
    - After logging in, navigate to the "Rented House" tab.
    - Click on the "Rented House" tab to view information about the house you have rented.

3. **Choose a House for Rent:**
    - Navigate to the "House" tab from the navigation bar at the top of the page.
    - Browse through the list of available houses for rent.

4. **Send Rental Request:**
    - Select a house from the listed houses.
    - Click on the "Send Request" button to send a rental request for the chosen house.

5. **Report Mismatching Information:**
    - If you notice any mismatching information in the rental ad (e.g., number of rooms, heating type, etc.), you can report it.
    - Click on the "Report Ad" button associated with the house to report the issue. This report will be monitored by the government account.

6. **View Profile:**
    - Navigate to the "Profile" tab.
    - Click on the "Profile" tab to view your personal profile information.

## Landlord

### Step-by-Step Guide

1. **Log In:**
    - Open the login page.
    - Enter your credentials (username and password).
    - Click the "Log In" button.

2. **List a House for Rent:**
    - Navigate to the "List House" tab.
    - Fill in the details of the house (e.g., number of rooms, heating type, rental price, etc.).
    - Click on the "Submit" button to list the house for rent.

3. **Upload Rental Contract:**
    - Once a house is rented, navigate to the "Contracts" tab.
    - Select the rented house and upload the rental contract.
    - This contract will enable the government to monitor the agreement.

4. **Request Rent Increase:**
    - If you wish to increase the rent price before the contract expiration date, navigate to the "Rent Increase Request" tab.
    - Fill in the necessary details and submit the request.
    - The government will be notified and must consent to the increase.

5. **View Rental Requests:**
    - Navigate to the "Rental Requests" tab.
    - Review the rental requests sent by tenants.
    - Approve or reject the requests accordingly.

6. **View Profile:**
    - Navigate to the "Profile" tab.
    - Click on the "Profile" tab to view your personal profile information.

## Real Estate Agent

### Step-by-Step Guide

1. **Log In:**
    - Open the login page.
    - Enter your credentials (username and password).
    - Click the "Log In" button.

2. **Manage House Listings:**
    - Navigate to the "Manage Listings" tab.
    - View and manage all house listings assigned to you.
    - Update details, add new houses, or remove existing listings as needed.

3. **Facilitate Rental Agreements:**
    - Navigate to the "Agreements" tab.
    - Assist in the facilitation of rental agreements between tenants and landlords.
    - Ensure all necessary documentation is uploaded and properly filled out.

4. **Assist with Rent Increase Requests:**
    - Navigate to the "Rent Increase Requests" tab.
    - Assist landlords in filling out and submitting rent increase requests.
    - Ensure all details are accurate and the process is followed correctly.

5. **View Profile:**
    - Navigate to the "Profile" tab.
    - Click on the "Profile" tab to view your personal profile information.

## Government Official

### Step-by-Step Guide

1. **Log In:**
    - Open the login page.
    - Enter your credentials (username and password).
    - Click the "Log In" button.

2. **Monitor Rental Ads:**
    - Navigate to the "Monitor Ads" tab.
    - Review rental ads and check for any reported mismatching information.
    - Take appropriate actions to address any discrepancies.

3. **Approve Rental Prices:**
    - Navigate to the "Rental Price Requests" tab.
    - Review requests from tenants for official rental price determinations.
    - Approve or adjust the rental prices accordingly.

4. **Monitor Contracts:**
    - Navigate to the "Contracts" tab.
    - Review and monitor uploaded rental contracts from landlords.
    - Ensure compliance with regulations and address any issues.

5. **Approve Rent Increase Requests:**
    - Navigate to the "Rent Increase Requests" tab.
    - Review and approve or reject requests for rent increases from landlords.
    - Ensure that any approved increases are fair and justified.

6. **Manage Deposit Refunds:**
    - Navigate to the "Deposit Refunds" tab.
    - Review the condition of houses after the contract expires and decide on the refund of deposit money.
    - Ensure fair resolution of disputes between tenants and landlords regarding the deposit.

7. **View Profile:**
    - Navigate to the "Profile" tab.
    - Click on the "Profile" tab to view your personal profile information.
```

# Contributors
* Arda YILDIZ
* Mustafa Kaan KOÇ
* Yusuf ŞENYÜZ
* Cengizhan TERZİOĞLU
* Yunus Eren TÜRKERİ

# Logbooks
* Arda YILDIZ: https://docs.google.com/document/d/1JD2DC3SZcpdVFzoJXnEynOGqjN9cDGvMddlsphlMjNQ/edit?usp=sharing
* Mustafa Kaan KOÇ: https://docs.google.com/document/d/11J_PcfWRUlxcmNHNzZ7YW6VHv1mWynNtbgEhgXM8Xcw/edit?usp=sharing
* Yusuf ŞENYÜZ: https://docs.google.com/document/d/1GlnVQByT7O4Wbj9pwznJdGIZARnO51tXKMkgk7DZmUM/edit?usp=drivesdk
* Cengizhan TERZİOĞLU: https://docs.google.com/document/d/1-2rHcBvovujAJ8S7DnBeZqIczzPMWqDI1B3tczMX18U/edit?usp=sharing
* Yunus Eren TÜRKERİ: https://docs.google.com/document/d/1V9wmsR8FfojrUZ4gsjEHHQpp656wCAUSxaEiTpek-bA/edit?usp=sharing

# Contact
Please reach out to Arda YILDIZ for questions and business inquiries.
* E-Mail: yarda@ug.bilkent.edu.tr

