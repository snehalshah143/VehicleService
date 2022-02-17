package com.snehal.carservice.constants;

import java.io.Serializable;

public enum AssignmentStatus implements Serializable {
  NOT_STARTED(1, "Assignment Not Started"),
  STARTED(2, "Assignment Started"),
  COMPLETE(3, "Assignment Completed"),
  ABORTED(4, "Assignment Aborted");

  private String description;
  private int id;

  AssignmentStatus(int id, String description) {
    this.id = id;
    this.description = description;
  }

  public String getDescription() {
    return this.description;
  }

  public int getId() {
    return this.id;
  }
}
