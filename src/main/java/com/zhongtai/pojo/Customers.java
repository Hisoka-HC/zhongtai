 package com.zhongtai.pojo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

 public class Customers{
     public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

   private Integer id;
   private String name;
   private String number;
   private String phone;
   private Integer organizeId;
   private Double applyMoney;
  private Integer processId;
  private Double borrowMoney;
  private Integer userId;
  private String submitDatetime;
  private Process process;
  private Organization organization;
  private Users users;
  private Groups groups;
  private Department department;

     @Override
     public String toString() {
         return "Customers{" +
                 "id=" + id +
                 ", name='" + name + '\'' +
                 ", number='" + number + '\'' +
                 ", phone='" + phone + '\'' +
                 ", organizeId=" + organizeId +
                 ", applyMoney=" + applyMoney +
                 ", processId=" + processId +
                 ", borrowMoney=" + borrowMoney +
                 ", userId=" + userId +
                 ", submitDatetime='" + submitDatetime + '\'' +
                 ", process=" + process +
                 ", organization=" + organization +
                 ", users=" + users +
                 ", groups=" + groups +
                 ", department=" + department +
                 '}';
     }

     /*public String getSubmitDatetime() {
         Date date = new Date();
         return  DATE_FORMAT.format(date);
     }*/

     public Groups getGroups() {
         return groups;
     }

     public void setGroups(Groups groups) {
         this.groups = groups;
     }

     public Department getDepartment() {
         return department;
     }

     public void setDepartment(Department department) {
         this.department = department;
     }

     public String getSubmitDatetime() {
         return submitDatetime;
     }

     public void setSubmitDatetime(String submitDatetime) {
         this.submitDatetime = submitDatetime;
     }

     public Process getProcess() {
         return process;
     }

     public void setProcess(Process process) {
         this.process = process;
     }

     public Organization getOrganization() {
         return organization;
     }

     public void setOrganization(Organization organization) {
         this.organization = organization;
     }

     public Users getUsers() {
         return users;
     }

     public void setUsers(Users users) {
         this.users = users;
     }

     public Integer getOrganizeId() {
         return organizeId;
     }

     public void setOrganizeId(Integer organizeId) {
         this.organizeId = organizeId;
     }

     public Integer getId() {
         return id;
     }

     public void setId(Integer id) {
         this.id = id;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public String getNumber() {
         return number;
     }

     public void setNumber(String number) {
         this.number = number;
     }

     public String getPhone() {
         return phone;
     }

     public void setPhone(String phone) {
         this.phone = phone;
     }

     public Double getApplyMoney() {
         return applyMoney;
     }

     public void setApplyMoney(Double applyMoney) {
         this.applyMoney = applyMoney;
     }

     public Integer getProcessId() {
         return processId;
     }

     public void setProcessId(Integer processId) {
         this.processId = processId;
     }

     public Double getBorrowMoney() {
         return borrowMoney;
     }

     public void setBorrowMoney(Double borrowMoney) {
         this.borrowMoney = borrowMoney;
     }

     public Integer getUserId() {
         return userId;
     }

     public void setUserId(Integer userId) {
         this.userId = userId;
     }


 }




