package com.example.bankapp.model;

//  imports 
import java.math.BigDecimal;
import org.springframework.security.core.GrantedAuthority;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

import java.util.List;
import java.util.Collection;

@Entity
public class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String username;
  private BigDecimal balance;

  @OneToMany(mappedBy = "account")
  private List<Transaction> transactions;

  @Transient
  private Collection<? extends GrantedAuthority> authorities;

  public Account(String username, BigDecimal balance, List<Transaction> transactions,
      Collection<? extends GrantedAuthority> authorities) {
    this.username = username;
    this.balance = balance;
    this.transactions = transactions;
    this.authorities = authorities;
  }

  // default constructor
  public Account() {

  }

  // getters & setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  public List<Transaction> getTransactions() {
    return transactions;
  }

  public void setTransactions(List<Transaction> transactions) {
    this.transactions = transactions;
  }

  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
    this.authorities = authorities;
  }

}
