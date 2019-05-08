/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hastane;

/**
 *
 * @author hasangenc
 */
public interface IUser {

  /**
   * @return the firstname
   */
  public String getFirstname();

  /**
   * @param firstname the firstname to set
   */
  public void setFirstname(String firstname);

  /**
   * @return the lastname
   */
  public String getLastname();

  /**
   * @param lastname the lastname to set
   */
  public void setLastname(String lastname);

  /**
   * @return the tcid
   */
  public String getTcid();

  /**
   * @param tcid the tcid to set
   */
  public void setTcid(String tcid);

  /**
   * @return the phone
   */
  public String getPhone();

  /**
   * @param phone the phone to set
   */
  public void setPhone(String phone);

  /**
   * @return the email
   */
  public String getEmail();

  /**
   * @param email the email to set
   */
  public void setEmail(String email);

  /**
   * @return the password
   */
  public String getPassword();

  /**
   * @param password the password to set
   */
  public void setPassword(String password);

}
