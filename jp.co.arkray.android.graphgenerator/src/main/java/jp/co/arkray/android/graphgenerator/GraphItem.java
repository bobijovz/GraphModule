package jp.co.arkray.android.graphgenerator;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GraphItem {
    private ArrayList<BGlucoseData> glucoseData = new ArrayList<>();
    private ArrayList<EventData> eventData = new ArrayList<>();
    private ArrayList<InsulinData> insulinData = new ArrayList<>();
    private ArrayList<MealData> mealData = new ArrayList<>();
    private ArrayList<MedsData> medsData = new ArrayList<>();
    private ArrayList<MemoData> memoData = new ArrayList<>();
    private ArrayList<MyScheduleData> schedData = new ArrayList<>();
    private List<DailyTotalData> dailyTotalData = new ArrayList<>();
    private ArrayList<InsulinPump> insulinPumpData = new ArrayList<>();


    public ArrayList<BGlucoseData> getGlucoseData() {
        return glucoseData;
    }

    public ArrayList<EventData> getEventData() {
        return eventData;
    }

    public ArrayList<InsulinData> getInsulinData() {
        return insulinData;
    }

    public ArrayList<MealData> getMealData() {
        return mealData;
    }

    public ArrayList<MedsData> getMedsData() {
        return medsData;
    }

    public ArrayList<MemoData> getMemoData() {
        return memoData;
    }

    public ArrayList<MyScheduleData> getSchedData() {
        return schedData;
    }

    public List<DailyTotalData> getDailyTotalData() {
        return dailyTotalData;
    }

    public ArrayList<InsulinPump> getInsulinPumpData() {
        return insulinPumpData;
    }

    public static class BGlucoseData {
        private Date timeStamp;
        private int glucoseMg;
        private float glucoseMmol;
        private int measureTiming;

        public BGlucoseData(Date timeStamp, int glucoseMg, float glucoseMmol, int measureTiming) {
            this.timeStamp = timeStamp;
            this.glucoseMg = glucoseMg;
            this.glucoseMmol = glucoseMmol;
            this.measureTiming = measureTiming;
        }

        public DateTime getDateTime(){
            return new DateTime(timeStamp);
        }

        public Date getTimeStamp() {
            return timeStamp;
        }

        public int getGlucoseMg() {
            return glucoseMg;
        }

        public float getGlucoseMmol() {
            return glucoseMmol;
        }

        public int getMeasureTiming() {
            return measureTiming;
        }
    }

    public static class MedsData {
        private Date timeStamp;

        public MedsData(Date timeStamp) {
            this.timeStamp = timeStamp;
        }

        public DateTime getDateTime(){
            return new DateTime(timeStamp);
        }

        public Date getTimeStamp() {
            return timeStamp;
        }
    }

    public static class MemoData {
        private Date timeStamp;
        private int memoId;
        private byte[] memoPic;
        private String memoText;
        private int memoMood;

        public MemoData(Date timeStamp, int memoId, byte[] memoPic, String memoText, int memoMood) {
            this.timeStamp = timeStamp;
            this.memoId = memoId;
            this.memoPic = memoPic;
            this.memoText = memoText;
            this.memoMood = memoMood;
        }

        public DateTime getDateTime(){
            return new DateTime(timeStamp);
        }

        public Date getTimeStamp() {
            return timeStamp;
        }

        public int getMemoId() {
            return memoId;
        }

        public byte[] getMemoPic() {
            return memoPic;
        }

        public String getMemoText() {
            return memoText;
        }

        public int getMemoMood() {
            return memoMood;
        }
    }

    public static class MealData {
        private Date timeStamp;
        private int calorieValue;
        private Double carboValue;
        private byte[] mealPic;
        private int mealType;

        public MealData(Date timeStamp, int calorieValue, Double carboValue, byte[] mealPic, int mealType) {
            this.timeStamp = timeStamp;
            this.calorieValue = calorieValue;
            this.carboValue = carboValue;
            this.mealPic = mealPic;
            this.mealType = mealType;
        }

        public DateTime getDateTime(){
            return new DateTime(timeStamp);
        }

        public Date getTimeStamp() {
            return timeStamp;
        }

        public int getCalorieValue() {
            return calorieValue;
        }

        public Double getCarboValue() {
            return carboValue;
        }

        public byte[] getMealPic() {
            return mealPic;
        }

        public int getMealType() {
            return mealType;
        }
    }

    public static class EventData {
        private Date timeStamp;
        private int eventId;

        public EventData(Date timeStamp, int eventId) {
            this.timeStamp = timeStamp;
            this.eventId = eventId;
        }

        public DateTime getDateTime(){
            return new DateTime(timeStamp);
        }

        public Date getTimeStamp() {
            return timeStamp;
        }

        public int getEventId() {
            return eventId;
        }
    }

    public static class InsulinData {
        private Date timeStamp;
        private int insulinId;
        private int InsulinValue;

        public InsulinData(Date timeStamp, int insulinId, int insulinValue) {
            this.timeStamp = timeStamp;
            this.insulinId = insulinId;
            InsulinValue = insulinValue;
        }

        public DateTime getDateTime(){
            return new DateTime(timeStamp);
        }

        public Date getTimeStamp() {
            return timeStamp;
        }

        public int getInsulinId() {
            return insulinId;
        }

        public int getInsulinValue() {
            return InsulinValue;
        }
    }

    public static class MyScheduleData {
        private Integer mEventID;
        private Integer mColor;
        private Date startDate;
        private Date endDate;
        private String schedTitle;
        private Boolean isAllDay;

        public MyScheduleData(Integer mEventID, Integer mColor, Date startDate, Date endDate, String schedTitle, Boolean isAllDay) {
            this.mEventID = mEventID;
            this.mColor = mColor;
            this.startDate = startDate;
            this.endDate = endDate;
            this.schedTitle = schedTitle;
            this.isAllDay = isAllDay;
        }

        public DateTime getStartDate() {
            return new DateTime(startDate);
        }

        public DateTime getEndDate() {
            return new DateTime(endDate);
        }

        public Integer getmEventID() {
            return mEventID;
        }

        public Integer getmColor() {
            return mColor;
        }

        public String getSchedTitle() {
            return schedTitle;
        }

        public Boolean getAllDay() {
            return isAllDay;
        }
    }

    public static class DailyTotalData {
        private Date dateTime;
        private int EnergyIntake;
        private float Carbohydrate;
        private int NoEnergyIntakeInput;
        private int NoCarbohydrateInput;
        private float PumpData;
        private float BasalData;
        private float BolusData;
        private int StepsData;
        private Boolean isPumpEnabled = false;

        public DailyTotalData(Date dateTime, int energyIntake, float carbohydrate, int noEnergyIntakeInput, int noCarbohydrateInput, float pumpData, float basalData, float bolusData, int stepsData, Boolean isPumpEnabled) {
            this.dateTime = dateTime;
            EnergyIntake = energyIntake;
            Carbohydrate = carbohydrate;
            NoEnergyIntakeInput = noEnergyIntakeInput;
            NoCarbohydrateInput = noCarbohydrateInput;
            PumpData = pumpData;
            BasalData = basalData;
            BolusData = bolusData;
            StepsData = stepsData;
            this.isPumpEnabled = isPumpEnabled;
        }

        public DailyTotalData(Date dateTime) {
            this.dateTime = dateTime;
        }

        public DateTime getDateTime() {
            return new DateTime(dateTime);
        }

        public float getPumpData() {
            if(BasalData != 0 || BolusData != 0) {
                PumpData = BasalData + BolusData;
            } else {
                PumpData = 0.0f;
            }
            return PumpData;
        }

        public int getEnergyIntake() {
            return EnergyIntake;
        }

        public float getCarbohydrate() {
            return Carbohydrate;
        }

        public int getNoEnergyIntakeInput() {
            return NoEnergyIntakeInput;
        }

        public int getNoCarbohydrateInput() {
            return NoCarbohydrateInput;
        }

        public float getBasalData() {
            return BasalData;
        }

        public float getBolusData() {
            return BolusData;
        }

        public int getStepsData() {
            return StepsData;
        }

        public Boolean getPumpEnabled() {
            return isPumpEnabled;
        }
    }

    public static class InsulinPump {
        private ArrayList<Double> basalData;
        private ArrayList<Double> bolusNormalData;
       // private ArrayList<IntArray> bolusNormalDataId;
        private ArrayList<Double> bolusSquareData;
        private ArrayList<Double> bolusSquareCancelData;
        private ArrayList<Integer> pumpStop;

        public InsulinPump(ArrayList<Double> basalData, ArrayList<Double> bolusNormalData, /*ArrayList<IntArray> bolusNormalDataId,*/ ArrayList<Double> bolusSquareData, ArrayList<Double> bolusSquareCancelData, ArrayList<Integer> pumpStop) {
            this.basalData = basalData;
            this.bolusNormalData = bolusNormalData;
            //this.bolusNormalDataId = bolusNormalDataId;
            this.bolusSquareData = bolusSquareData;
            this.bolusSquareCancelData = bolusSquareCancelData;
            this.pumpStop = pumpStop;
        }

        public Double getBasalData(int i) {
            return basalData.size() > 0 && basalData.get(i) != 0 ? basalData.get(i) : 0.0;
        }

        public Double getBolusNormalData(int i) {
            return bolusNormalData.size() > 0 && bolusNormalData.get(i) != 0 ? bolusNormalData.get(i) : 0.0;
        }

       /* public ArrayList<IntArray> getBolusNormalDataId() {
            return bolusNormalDataId;
        }*/

        public Double getBolusSquareData(int i) {
            return bolusSquareData.get(i);
        }

        public Double getBolusSquareCancelData(int i) {
            return bolusSquareCancelData.get(i);
        }

        public ArrayList<Integer> getPumpStop() {
            return pumpStop;
        }

        public boolean IsSquareToBasalVerticalLine(int index) {
            if (getBolusSquareData(index) == 0){
                return false;
            }
            if (index == 0){
                return getBolusSquareData(index + 1) == 0;
            }else if (index == (bolusSquareData.size()-1)){
                return getBolusSquareData(index - 1) == 0;
            }else{
                return (getBolusSquareData(index - 1) == 0) ||
                        (getBolusSquareData(index + 1) == 0);
            }
        }
    }


   /* public class IntArray {
        private ArrayList<Integer> mdt;

        public IntArray(){
            mdt = new ArrayList<Integer>();
            mdt.clear();
        }

        public void Add(int dt){
            mdt.add(dt);
        }
        public int Get(int index){
            return mdt.get(index);
        }

        public int size(){
            return mdt.size();
        }
    }*/


}
