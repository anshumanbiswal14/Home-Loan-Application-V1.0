import { User } from "./User";

export class Customer extends User{
    
    customerName !: string;
    mobileNumber !: string;
    emailId !: string;
    dateOfBirth !: Date;
    gender !: string;
    nationality !: string;
    aadharNumber !: string;
    panNumber !: string;

}