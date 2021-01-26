public class SnakkesagligPerson implements Runnable {
    private String navn;
    private int ventetid;

    public SnakkesagligPerson(String n, int t)
    {
        navn = n;
        ventetid = t;
    }
    //TODO DELETE LATER
    public void run()
    {
        Controller controller = new Controller();
        for (int i = 0; i < 10000 ; i++) {
            System.out.println("waiting");
        }
        for (int i=0; i<1000; i++)
        {
            System.out.println(navn+": bla bla bla "+i);
            controller.runmetods();
            try {  Thread.sleep(ventetid); } catch (Exception e) {} // vent lidt
        }
    }
}

