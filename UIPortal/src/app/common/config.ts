export const ApiConfig = {
    serviceURL: 'http://localhost:8081/',
    performLogin: '/springboot-crud-rest/api/v1/login',
    updatePassword: '/springboot-crud-rest/api/v1/updatePassword',
    getEmployeeList: '/springboot-crud-rest/api/v1/employees',
    deleteEmployee: '/springboot-crud-rest/api/v1/employees',
    updateEmployee: '/springboot-crud-rest/api/v1/employees',
    generateEmployee: '/springboot-crud-rest/api/v1/employees'
};

export const Environment = {
    production: false,
    theme: 'light',
    dateFormat: "ddMMMyyyy",
    timeFormat: "HH:mm",
    dateTimeFormat: "ddMMMyyyy HH:mm",
    currencySymbol: 'INR',
    enableGuard: true,
    enableAuthHeader: true
};