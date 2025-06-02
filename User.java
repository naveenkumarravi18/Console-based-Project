package library;

public class User{
private String name;
private int  id;
private boolean subscription;
private String Pass;
public User(String name, boolean subscription,String pass) {
	super();
	this.name = name;
	
	this.subscription = subscription;
	this.Pass=pass;
}

public String getName() {
	return name;
}
public int getId() {
	return id;
}
public boolean isSubscription() {
	return subscription;
}

public String getPass() {
	  return Pass;
}}
