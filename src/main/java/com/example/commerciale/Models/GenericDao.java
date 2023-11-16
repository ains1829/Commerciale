package com.example.commerciale.Models;
import java.io.File;
import java.lang.reflect.*;
import java.sql.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Vector;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.nio.file.Files;
import java.io.IOException;

public class GenericDao
{ 
  Statement statement;
    public Statement getStatement(){    
        return statement;   
    }
    public void setStatement(Statement newStmt){     
        statement=newStmt; 
    }
  //---------------------------------------------------------------------------------------------------
    public void createStatementIfNull(Connection connection)throws Exception{
      if(statement==null){
        statement=connection.createStatement();
      }else if(statement.isClosed()==true){
        statement=connection.createStatement();
      }if(connection==null){
        throw new Exception("la connection est null");
      }
    }
//-----------------------------------------------------------------------------------------------------
    public void update(String sqlupdate,Connection connection)throws Exception{
      createStatementIfNull(connection);
      int nb=statement.executeUpdate(sqlupdate);
    }
    public void insert(String sqlinsert,Connection connection)throws Exception{
      createStatementIfNull(connection);
      int nb=statement.executeUpdate(sqlinsert);
    }
    public void delete(String sqldelete,Connection connection)throws Exception{
      createStatementIfNull(connection);
      int nb=statement.executeUpdate(sqldelete);
    }
//----------------------------------------------------------------------------------------------
//     public int getSequence(String nom)throws Exception{
//       ResultSet resultSet=statement.executeQuery("select "+nom+".NEXTVAL from dual");
//       resultSet.next();
//       String s=resultSet.getString(1);
//       resultSet.close();
//       return Integer.valueOf(s);
//     }
//-----------------------------------------------------------------------------------------------
public String DatetoFormatDataBase(String sDate){
  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
  return simpleDateFormat.format(Date.valueOf(sDate)).toString();
}
public String DatetoFormatDataBase(Date date){
  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
  return simpleDateFormat.format(date).toString();
}
//-----------------------------------------------------------------------------------------------recupere les valeur d'une table
    public String[][] valueSelectToString(String sqlSelect,Connection connection)throws Exception{
      createStatementIfNull(connection);
      Vector vresultat=new Vector();
      ResultSet resultSet=statement.executeQuery(sqlSelect);//
      ResultSetMetaData rsmd=resultSet.getMetaData();
      int nbcolumn=rsmd.getColumnCount(); //nb colonne 

      boolean encore=resultSet.next(); //mbola misy ve le ligne
      String[] col=null;
      while(encore){//if==true
          col=new String[nbcolumn];
          for(int i=1;i<=nbcolumn;i++){
            col[i-1]=resultSet.getString(i); //l'element en String du colonne numero i dans ce ligne
          }
          vresultat.add(col);
          encore=resultSet.next();//resultSet.next() : ligne suivante / encore= false si plus de ligne
      }
      if(col==null){ return null; }
      String[][] resultat=new String[vresultat.size()][nbcolumn];
      for(int i=0;i<vresultat.size();i++){
        resultat[i]=(String[])vresultat.elementAt(i);
      }
      resultSet.close();
      return resultat;
    }
//-----------------
public static byte[] convertFileToByteArray(File file) throws IOException {
  return Files.readAllBytes(file.toPath());
}
//----------------------------------------------------------------------------------------------------creation d'un objet avec un object de reference et ses valeur en String alignee selon l'alignement de l'attribut
public Object creerObject(Object objexample,String[] lstValueField)throws Exception{
  Object obj =objexample.getClass().getDeclaredConstructor().newInstance();
  //-------------------
  //recuperer les Attribus pour savoir leurs noms et avoir les fonctions setter a partir de ces noms
  Field[] fld=obj.getClass().getDeclaredFields();
  Method[] sesMethod=obj.getClass().getDeclaredMethods();//recuperer touts de suite tous les methodes 
  int a=0;
    for(int i=0;i<lstValueField.length;i++)
    {
        //recuperation de l'indice du methode equivalant a l'atribu, car le tableau des methodes sont en desordre lorsqu'on les recupere
        for(int u=0;u<sesMethod.length;u++){   if(sesMethod[u].getName().compareTo( to_setAttribu(fld[i].getName()) )==0 && sesMethod[u].getParameterTypes()[0].getSimpleName().compareTo(fld[i].getType().getSimpleName())==0){     a=u;  }  }
          String type=fld[i].getType().getSimpleName();
          if(lstValueField[i]!=null){
                if(type.compareTo("int")==0){
                int paramt=Integer.valueOf(lstValueField[i]);
                //System.out.println("-->"+sesMethod[a].getName()+"------>"+sesMethod[a].getParameterTypes()[0].getTypeName()+"--->"+paramt);
                sesMethod[a].invoke(obj,paramt);
                }else if(type.compareTo("long")==0){
                      long paramt=Long.valueOf(lstValueField[i]);
                      sesMethod[a].invoke(obj,paramt);
                }else if(type.compareTo("float")==0){
                      float paramt=Float.valueOf((lstValueField[i]));
                      sesMethod[a].invoke(obj,paramt);
                }else if(type.compareTo("char")==0){
                String str=lstValueField[i];
                char paramt=str.charAt(0);
                sesMethod[a].invoke(obj,paramt);
                }else if(type.compareTo("String")==0){
                sesMethod[a].invoke(obj,lstValueField[i]);
                }else if(type.compareTo("double")==0){
                double paramt=Double.valueOf(lstValueField[i]);
                sesMethod[a].invoke(obj,paramt);
                }else if(type.compareTo("LocalDate")==0){ //annee-mois-jours
                      String [] strDt=lstValueField[i].split("-");
                      String[] forJour=strDt[2].split(" ");
                      LocalDate date=LocalDate.of(Integer.valueOf(strDt[0]), Integer.valueOf(strDt[1]) , Integer.valueOf(forJour[0]) );
                      sesMethod[a].invoke(obj,date);
                }else if(type.compareTo("LocalDateTime")==0){ //annee-mois-jours
                      String[] ld1=lstValueField[i].split(" ");
                      String[] ld2=ld1[0].split("-");
                      String[] ld3=ld1[1].split(":");
                      LocalDateTime ldt=LocalDateTime.of(Integer.valueOf(ld2[0]),Integer.valueOf(ld2[1]),Integer.valueOf(ld2[2]),Integer.valueOf(ld3[0]),Integer.valueOf(ld3[1]),Integer.valueOf(ld3[2]));
                      sesMethod[a].invoke(obj,ldt);
                }else if(type.compareTo("Date")==0){
                      Date date=Date.valueOf(lstValueField[i]);
                      sesMethod[a].invoke(obj,date);
                }else if(type.compareTo("Time")==0){
                      Time time=Time.valueOf(lstValueField[i]);
                      sesMethod[a].invoke(obj,time);
                }else if(type.compareTo("boolean")==0){
                      boolean paramt=Boolean.valueOf(lstValueField[i]);
                      sesMethod[a].invoke(obj,paramt);
                }
          }
    }
  return obj;      
}

//---------------------------------------------------creation du tableau d'objet dont leurs valeurs est dans un String[][]
public Object[] creerLstObjects(Object objexample,String[][] lstValueField)throws Exception{
    if(lstValueField==null){ return null; }
    Object[] lstobj=new Object[lstValueField.length];
    for (int i=0;i<lstValueField.length;i++){ lstobj[i]=creerObject(objexample, lstValueField[i]);  }
    return lstobj;
}
//----------------------------------------------------
public Object[] creerLstObjects(Object objexample,Connection connection,String sqlSelect)throws Exception{
  String [][] lstValueField=valueSelectToString(sqlSelect,connection);
  Object[] lstobj=creerLstObjects(objexample, lstValueField);
  return lstobj;
}
//-----------------------------------------------------

    public String writeValueAccordingType(String type,Object value){ //---date--2022/02/03---> '2022/02/03' , int--3--> 3
      if(value==null){  return "NULL";  }
      int siString=type.compareTo("String");
      int siDate=type.compareTo("Date");
      int siLocalDate=type.compareTo("LocalDate");
      int siTime=type.compareTo("Time");
      int siLocalDateTime=type.compareTo("LocalDateTime");

      int valeurfinal=siString*siDate*siLocalDate*siTime*siLocalDateTime; //---> si 0 --> v-d-r que 1 de ces type est vrai
      if(type.compareTo("FileUpload")==0){
        String val="\'"+value.toString()+"\'";
        //raha date le izy de avadika format date
        return val;
      }
      if(siLocalDateTime==0){
         LocalDateTime ldatetime = (LocalDateTime)value;
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
         String formattedDateTime = "\'"+ldatetime.format(formatter)+"\'";
          return formattedDateTime;
      }else if(siDate==0){
          SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
          Date date=(Date)value;
          return "\'"+simpleDateFormat.format(date).toString()+"\'";
      }else if(siLocalDate==0){
          SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
          LocalDate ldate=(LocalDate)value;
          return "\'"+simpleDateFormat.format(Date.valueOf(ldate)).toString()+"\'";
      }else if(valeurfinal==0){
        String val="\'"+value+"\'";
        return val;
      }else{ return value.toString()+""; }
    }
//------------------------------------------------------exemple= "nom"----to---->"getNom"  et   "nom"----to---->"setNom" 
      public String to_getAttribu(String nomAttribu,String typeField)
      {
            String getAttribMaj="get";
            if(typeField.compareToIgnoreCase("boolean")==0){  getAttribMaj="is";  }
            String attrib=nomAttribu.substring(0,1).toUpperCase(); //rendre en majuscul la premiere lettre du nomAtribu
            String restattrib=nomAttribu.substring(1,nomAttribu.length());  //prendre les lettres a partir du 2e lettre
            getAttribMaj=getAttribMaj.concat(attrib+restattrib);  //fusionner pour avoir le nom de fonction "getAtribu"
                         //Method m=c.getMethod("getVar1");
            return getAttribMaj;
      }
      public String to_setAttribu(String nomAttribu)
      {
            String getAttribMaj="set";
            String attrib=nomAttribu.substring(0,1).toUpperCase(); //rendre en majuscul la premiere lettre du nomAtribu
            String restattrib=nomAttribu.substring(1,nomAttribu.length());  //prendre les lettres a partir du 2e lettre=
            getAttribMaj=getAttribMaj.concat(attrib+restattrib); //fusionner pour avoir le nom de fonction "getAtribu"
             //Method m=c.getMethod("getVar1");
            return getAttribMaj;
      }
//---------------------------------------------------------------------------------------------------------------------save/Insert
  public void save(Object object,Connection connection,String nameprimaryKey)throws Exception{
    String siPkNull="##$$##$$;;";
    if(nameprimaryKey==null){ nameprimaryKey=siPkNull; }
    String nom=object.getClass().getSimpleName();  
    String requet="insert into "+nom + " (";
    Field[] fields=object.getClass().getDeclaredFields();
    String values=" values(";
    for(int i=0;i<fields.length;i++){
      if(fields[i].getName().compareToIgnoreCase(nameprimaryKey)!=0){
        requet=requet+fields[i].getName(); //"insert into nomObj ( "+ ? +","+ ? + ...
        //String val=String.valueOf( object.getClass().getMethod( to_getAttribu(fields[i].getName(),fields[i].getType().toString()) ).invoke(object) );
        Object obj= object.getClass().getMethod( to_getAttribu(fields[i].getName(),fields[i].getType().toString()) ).invoke(object) ;

        if(obj!=null){ values=values+writeValueAccordingType(fields[i].getType().getSimpleName(),obj); }
        else{ values=values+obj.toString();  }
        if(i+1<fields.length){
          requet=requet+",";  values=values+",";
        }
      }
    }
    requet=requet+")"+values+")";
    ////////////
    System.out.println("before execut : "+requet); 
    this.insert(requet, connection);
    System.out.println("after execut : "+requet); 
    ////////////

    if(nameprimaryKey.compareToIgnoreCase(siPkNull)!=0){
      String[][] lastId=this.valueSelectToString("select max("+nameprimaryKey+") from "+object.getClass().getSimpleName(), connection);
      Method[] sesMeths=object.getClass().getDeclaredMethods();
      int u=-1;
      for(int i=0;i<sesMeths.length;i++){   if(sesMeths[i].getName().compareTo( to_setAttribu(nameprimaryKey))==0){ u=i;}   }
      if(u>=0 && u<sesMeths.length){   sesMeths[u].invoke(object,Integer.valueOf(lastId[0][0]));  }
    }
  }
//----------------------------------------------------------------------------------------------------------update
  public void update(Object object,Connection connection,String nameprimaryKey)throws Exception{ 
    //update emp set col=valCol where condition
    String nom=object.getClass().getSimpleName(); 
    String requete="update "+nom + " set ";
    String colAndVal="";
    Field[] fields=object.getClass().getDeclaredFields();
    for(int i=0;i<fields.length;i++){
        Object val=object.getClass().getMethod( to_getAttribu(fields[i].getName(), fields[i].getType().getSimpleName() ) ).invoke( object );
        if(val!=null){ colAndVal=colAndVal+" "+fields[i].getName()+"="+writeValueAccordingType(fields[i].getType().getSimpleName(), val )+","; }
        else{ colAndVal=colAndVal+"="+"NULL"+",";  }  
    }
    if(colAndVal.length()>0){ colAndVal=colAndVal.substring(0, colAndVal.length()-1); } //on prend en enlevant la virgule a la fin 
    if(nameprimaryKey!=null){
      Field fpk=object.getClass().getDeclaredField(nameprimaryKey);
      Object valpk=object.getClass().getMethod( to_getAttribu( nameprimaryKey, fpk.getType().getSimpleName() ) ).invoke(object); //le pk de this pour update 
      colAndVal=colAndVal+" where "+nameprimaryKey+"="+ writeValueAccordingType(fpk.getType().getSimpleName(), valpk);
    }else{ throw new Exception("pk null, nom primary key obligatoire pour update"); }
    requete=requete+colAndVal;
    ////////////
    System.out.println("before execut : "+requete); 
    this.update(requete, connection);
    System.out.println("after execut : "+requete); 
    ////////////
  }
//-------------------------------------------------------------------------------------------------------------delete
  public void delete(Object object,Connection connection,String nameprimaryKey)throws Exception{
    String nom=object.getClass().getSimpleName(); 
    String requet="delete from "+nom;
    String condition=" where";
    if(nameprimaryKey==null){
      Field[] fields=object.getClass().getDeclaredFields();
      for(int i=0;i<fields.length;i++){
        condition=condition+" ";
        Object val=object.getClass().getMethod( to_getAttribu(fields[i].getName(), fields[i].getType().getSimpleName()) ).invoke( object );
        if(val!=null){ condition=condition+" "+fields[i].getName()+"="+writeValueAccordingType(fields[i].getType().getSimpleName(),val)+" and"; }
        else{ condition=condition+"="+"NULL"+" and";  }
      }
      if(condition.length()>0){ condition=condition.substring(0, condition.length()-3); } //on prend en enlevant la virgule a la fin
    }else{
      Field fpk=object.getClass().getDeclaredField(nameprimaryKey);
      Object valpk=object.getClass().getMethod( to_getAttribu( nameprimaryKey, fpk.getType().getSimpleName() ) ).invoke(object); 
      condition=condition+" "+nameprimaryKey +"="+writeValueAccordingType(fpk.getType().getSimpleName(), valpk);
    }
    requet=requet+condition;
    ////////////
    System.out.println("before execut : "+requet);
    this.delete(requet, connection);
    System.out.println("after execut : "+requet); 
    ////////////
  }
//---------------------------------------------------------------------------------------------------------------
  public Object find(Object object,Connection connection,String nameprimaryKey)throws Exception{
    String nom=object.getClass().getSimpleName(); 
    String requet="select * from "+nom;
    String condition=" where ";
    if(nameprimaryKey==null){
      Field[] fields=object.getClass().getDeclaredFields();
      for(int i=0;i<fields.length;i++){
        condition=condition+" ";
        Object val=object.getClass().getMethod( to_getAttribu(fields[i].getName(),fields[i].getType().getSimpleName()) ).invoke( object );
        if(val!=null){ condition=condition+" "+fields[i].getName()+"="+writeValueAccordingType(fields[i].getType().getSimpleName(),val)+" and"; }
        else{ condition=condition+"="+"NULL"+" and";  }
      }
      if(condition.length()>0){ condition=condition.substring(0, condition.length()-3); } //on prend en enlevant la virgule a la fin
    }else{
      Field fpk=object.getClass().getDeclaredField(nameprimaryKey);
      Object valpk=object.getClass().getMethod( to_getAttribu( nameprimaryKey, fpk.getType().getSimpleName() ) ).invoke(object); 
      condition=condition+" "+nameprimaryKey +"="+writeValueAccordingType(fpk.getType().getSimpleName(), valpk);
    }
    requet=requet+condition;
    ////////////
    System.out.println("before execut : "+requet);
    Object[] objs=this.creerLstObjects(object,connection, requet);
    System.out.println("after execut : "+requet); 
    ///////////
    if(objs==null){ return null; }
    return objs[0];
  }
//---------------------------------------------------------------------------------------------------------------find All 
  public Object[] findAll(Object object,Connection connection)throws Exception{
    Object[] objs=this.creerLstObjects(object,connection, "select * from "+object.getClass().getSimpleName());
    return objs;
  }
  
}