export const ApiConfig = {
    serviceURL: 'http://localhost:8081',
    performLogin: '/authenticate',
    departmentList: '/departmentList',
    getEmployeeList: '/userlist',
    deleteEmployee: '/unregister',
    updateEmployee: '/updateuser',
    generateEmployee: '/register'
};

export const Environment = {
    production: false,
    theme: 'light',
    dateFormat: 'ddMMMyyyy',
    timeFormat: 'HH:mm',
    dateTimeFormat: 'ddMMMyyyy HH:mm',
    currencySymbol: 'INR',
    enableGuard: true,
    enableAuthHeader: true
};
