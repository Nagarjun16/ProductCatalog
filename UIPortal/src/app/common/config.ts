export const ApiConfig = {
    serviceURL: 'http://localhost:8081/',
    performLogin: '/api/v1/login',
    updatePassword: '/api/v1/updatePassword',
    getEmployeeList: '/api/v1/employees',
    deleteEmployee: '/api/v1/employees',
    updateEmployee: '/api/v1/employees',
    generateEmployee: '/api/v1/employees'
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