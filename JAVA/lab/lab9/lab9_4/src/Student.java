public class Student {
    private String name;
    private char gender;
    public Student(){
        this("Unknown",'u');
    }
    public Student(String name,char gender){
        this.name=name;
        this.gender=gender;
    }
    public Student(String name){
        this(name,'u');
    }
    public Student(char gender){
        this("Unknown",gender);
    }
    public void display(){
        System.out.println("Name: "+name);
        if(gender=='u'){
            System.out.println("Gender: Unknown");
        }
        if(gender=='m'){
            System.out.println("Gender: Male");
        }
        if(gender=='f'){
            System.out.println("Gender: Female");
        }

    }
}
