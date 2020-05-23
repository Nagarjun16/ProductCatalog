export const ApiConfig = {
    serviceURL: 'http://localhost:8081',
    performLogin: '/authenticate',
    departmentList: '/dropdown/departmentList',
    getUserList: '/userlist',
    registerUser: '/register',
    updateUser: '/updateuser',
    unregisterUser: '/unregister'
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
