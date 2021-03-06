package entity;
import java.io.Serializable;

/**
 * Model class of 客户.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class Customer implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** id. */
	private Long id;

	/** name. */
	private String name;

	/** password. */
	private String password;

	/** real_name. */
	private String realName;

	/** email. */
	private String email;

	/** question. */
	private String question;

	/** answer. */
	private String answer;
 
	private String phone;
	private int point;
	/**
	 * Constructor.
	 */
	public Customer() {
	}
	
	public void setPoint(int point) {
		this.point = point;
	}

	/**
	 * Get the id.
	 * 
	 * @return id
	 */
	public int getPoint() {
		return this.point;
	}
	
	
	
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Get the id.
	 * 
	 * @return id
	 */
	public String getPhone() {
		return this.phone;
	}
	

	/**
	 * Set the id.
	 * 
	 * @param id
	 *            id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Get the id.
	 * 
	 * @return id
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * Set the name.
	 * 
	 * @param name
	 *            name
	 */
	
	
	
	
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the name.
	 * 
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Set the password.
	 * 
	 * @param password
	 *            password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Get the password.
	 * 
	 * @return password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Set the real_name.
	 * 
	 * @param realName
	 *            real_name
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}

	/**
	 * Get the real_name.
	 * 
	 * @return real_name
	 */
	public String getRealName() {
		return this.realName;
	}

	/**
	 * Set the email.
	 * 
	 * @param email
	 *            email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get the email.
	 * 
	 * @return email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Set the question.
	 * 
	 * @param question
	 *            question
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * Get the question.
	 * 
	 * @return question
	 */
	public String getQuestion() {
		return this.question;
	}

	/**
	 * Set the answer.
	 * 
	 * @param answer
	 *            answer
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 * Get the answer.
	 * 
	 * @return answer
	 */
	public String getAnswer() {
		return this.answer;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Customer other = (Customer) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

}
