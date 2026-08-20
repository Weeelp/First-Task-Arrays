package com.project.app.entity;

import com.project.app.exception.ArrayValidationException;

public class DoubleArrayWrapper extends AbstractArrayWrapper {
  private final double[] elements;

  public DoubleArrayWrapper (int id, double[] elements) throws ArrayValidationException{
    super(id);

    if (elements == null) {
      throw new ArrayValidationException("Elements array is null");
    }
    this.elements = elements.clone();
  }

  public double getElement (int ind) throws ArrayValidationException { 
    if (elements == null || ind < 0 || ind >= elements.length) {
        throw new ArrayValidationException("Invalid array ind: " + ind);
    }
    
    return elements[ind]; 
  }

  public void setElement(int ind, double newValue) throws ArrayValidationException {
    if (ind < 0 || ind >= elements.length) {
      throw new ArrayValidationException("Invalid array ind: " + ind);
    }
    this.elements[ind] = newValue;
    notifyObserver(); 
  }

  public double[] getAll () {     
    return elements.clone(); 
  }

  public int size() { return elements.length; }

  @Override
    public int hashCode() {
      int result = (int) (getId() ^ (getId() >>> 32));
      for (double element : elements) {
        long bits = Double.doubleToLongBits(element);
        result = 31 * result + (int) (bits ^ (bits >>> 32));
      }
      return result;
    }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    DoubleArrayWrapper other = (DoubleArrayWrapper) obj;
    if (getId() != other.getId()) {
      return false;
    }
    if (elements.length != other.elements.length) {
      return false;
    }
    for (int i = 0; i < elements.length; i++) {
      if (Double.compare(elements[i], other.elements[i]) != 0) {
        return false;
      }
    }

    return true;
  }

  public double[] toArray(){
    return elements;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("DoubleArrayWrapper: { id = ");
    sb.append(getId());
    sb.append(", elements = ");
    for(int i=0; i<elements.length; i++){
      sb.append(elements[i]);
      if (i<elements.length-1) {
        sb.append(", ");
      }
    }
    sb.append(" };");

    return sb.toString();
  }
}
