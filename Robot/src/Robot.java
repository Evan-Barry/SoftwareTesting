public class Robot {

    private String name;
    private int age;
    private boolean working = false;

    public Robot(String name, int age)
    {
        setName(name);
        setAge(age);
    }

    private void setName(String name)
    {
        if(name.isEmpty())
        {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    private void setAge(int age)
    {
        this.age = age;
    }

    public int getAge()
    {
        return age;
    }

    public boolean isWorking()
    {
        return working;
    }

    public void talkToRobot()
    {
        working = true;
    }

    public String getWorkingMessage()
    {
        if(!working)
        {
            throw new IllegalStateException();
        }

        return "I am in working mode";
    }

    public void waitTilWorking()
    {
        while(!working)
        {
            //do nothing
        }
    }
}
