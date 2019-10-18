package com.fedya.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

  private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

  public static String log(String label) {
    return label + " {" + formatter.format(new Date()) + "}";
  }
}
