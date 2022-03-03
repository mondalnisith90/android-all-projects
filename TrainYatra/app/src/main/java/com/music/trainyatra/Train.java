package com.music.trainyatra;

import java.util.ArrayList;

public class Train {

    private String train_name,train_number;

    private ArrayList<TrainClasses> train_classes_info;
    private ArrayList<TrainRunningDaysInfo> trainRunningDaysInfo;

    public Train(){}

    public void  setTrainInfoObject(String train_name, String train_number,ArrayList<TrainClasses> train_classes_info,ArrayList<TrainRunningDaysInfo> trainRunningDaysInfo) {
        this.train_name = train_name;
        this.train_number = train_number;
        this.train_classes_info = train_classes_info;
        this.trainRunningDaysInfo = trainRunningDaysInfo;
    }




    public TrainClasses getTrainClassesInfoObject(int index){

         /*this method will return a single object of TrainClasses class according to index number from
          train_classes_info ArrayList  */

        return this.train_classes_info.get(index);
    }

    public TrainRunningDaysInfo getTrainRunningDayInfoObject(int index){

        /*this method will return a single object of TrainRunningDaysInfo class according to index number from
          trainRunningDaysInfo ArrayList  */


        return this.trainRunningDaysInfo.get(index);
    }

    public ArrayList<Train.TrainRunningDaysInfo> getTrainRunningDaysInfoArrayList(){
        return trainRunningDaysInfo;
    }

    public ArrayList<Train.TrainClasses> getTrainClassesInfoArrayList(){
        return train_classes_info;
    }


    public void setTrainName(String train_name) {
        this.train_name = train_name;
    }

    public void setTrainNumber(String train_number) {
        this.train_number = train_number;
    }


    public String getTrainNumber() {
        return train_number;
    }

    public String getTrainName() {
        return train_name;
    }


    public int getNumberOfTotalClasses(){
        return train_classes_info.size();
    }



    // inner classes
//TrainRunningDaysInfo is a inner class.

    public class TrainRunningDaysInfo{

        /* this class stores in a day of a week the Train is Running or Not  */

        private String each_day,isTrain_run;  //isTrain_run value must be 'yes' or 'no'

        public TrainRunningDaysInfo(String each_day,String isTrain_run){
            //constractor
            this.each_day = each_day;
            this.isTrain_run = isTrain_run;
        }


        public void setTrainRunningDayNameAndStatus(String day,String isTrainRun){
            /*this method set what days of a week this train is Running. each_day store days of a week like SUNDAY,MONDAL,TUESDAY etc. and
              isTrain_run store that at a particular day the train will run or not . yes or no.......*/
            this.each_day = day;
            this.isTrain_run = isTrainRun;
        }

        public String getEachDay(){
            return this.each_day;
        }

        public String getIsTrainRun(){
            return this.isTrain_run;
        }


    }


  // This class stores the information about the classes of a train Lik  firstClass,AC CLASS etc.....
    public class TrainClasses{

        private String class_name,is_availabe;
         //is_availabe value must be yes or no....
      public TrainClasses(String class_name,String is_availabe){

          this.class_name = class_name;
          this.is_availabe = is_availabe;
      }

      public void setClassNameAndAvailablity(String class_name,String is_availabe) {
          this.class_name = class_name;
          this.is_availabe = is_availabe;
      }

      public String getClassName() {
          return this.class_name;
      }

      public String getIsClassAvailable(){
          return this.is_availabe;
      }
  }





















}
