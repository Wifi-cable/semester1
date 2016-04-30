.charAt(name der variable); nimmt einen charater eines strings (location 
    im string spezifiziert und packt in in das davor deffinierte array.
    int binArray[] = new int [bin.length()];
    for(int i=0; i<bin.length(); i++){ 
    binArray [i] =(int)bin.charAt(i)-(int)'0';}
    
    [i] ist das array, bin ist die string. die grösse des arrays richtet sich 
    nach der länge des strings. das i=0; und das i++ bedeutet das es bei der
    ersten stelle anfängt (was null ist) und immer ein weiteres dazu zählt.
    
    würde auch mit 4 gehen 
    
    for (int four=0 four<*.length(); four+4)
    **[four]=(int)*.charAt(four)-(int) '0';}
    
    *name des strings in dem die binär zahlen gespeichert sind
    ** name des arrays in das die binär zahlen gepackt werden sollen, die 
    im string waren.
    
klasse, methode object und wie es in die main passt.

class Point { double x, y;
            static int count;}
    Point.count  kann von jeder instanz der klasse "point" zugegriffen werden. es kann zb dazu genutzt
    werden die anzal der  instanzen von Points (punkte) zu speichern.
    das kann nützlich sein für den traveling salesman weil schliesslich die beste route gespeichert werden
    soll.
    
    public double x,y;  //methoden declaration
    public double distance (point ptk){
        double xdiff= x-ptk.x;  //kein "new x" weil es in der selben klasse ist und sie oben genannt sind
        double ydiff= y-ptk.y;
        return Math.sqrt(xdiff*xdiff+ ydiff*ydiff);
        }  
         //danach der methoden aufruf
         
        Class PointeTester{
        public static void main (String[] args){
            Point lowerLeft= new point(); lowerLeft.x=0,1;
            Point upperRight= new point(); upperRight.y=0,1;
            double d= lowerLeft.distance(upperRight);}
            
            class Point{} 
    
konstructor kein mehtode oder klasse, sondern speicherplatzreservierung, initial werte für variablen 
    belegt die intitial variablen mit werten. (auch kein rückgabewert) zb kann man eine variable mit mit
     dem title "name" haben und die dann mit verschiedenen strings belegen also verschiedene studenten
      anlegen und mit verschiedenen namen versehen. (wollen ja nicht das die studies nur nummern sind) 
      (mehrere pro klasse sind möglich)
      beispiel.
    class Student {
    private String matNr;
    private String name,
    private int semester;
    student (String name, String matNr ){
    this.student=name;
    this.matNr= matNr;
    }}
    /*jedes object der klasse stundent kann durch den konstruktor mit zb zwei werten initialiesiert werden
    in dem fall namen und martrikel nummer (name ist string und matnr irgentwie auch. wiso nicht int?*/
    student.clair = new student("Clair Grube","1234"); 
    
    es gibt auch default constuctoren,beispiel
    student s1=
    new student ("Hans Damf" "4321");
    //wenn kein constructor erstellt wurde macht java das aber halt ohne parameter
    student s=
    new student();
    
information hiding man kann direkten zugriff auf variablen auch verhindern, wenn die  methode nicht extra
    aufgerufen wurde. (nerfig wenns ausversehen passiert) die klassse ist dann versteckt implementiert.
    englisch dataencapsulation. private class sind gut dafür. kann sicherheitsrelevant sein. in dem fall
    wäre das
    public String getName(){return name;}//würde die private klass public machen 
    
    
    
    
    
    
