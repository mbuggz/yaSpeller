package model;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static utils.ListUtils.equalLists;

public class YandexSpeller {
  @SerializedName("code")
  private Integer code;

  @SerializedName("pos")
  private Integer pos;

  @SerializedName("row")
  private Integer row;

  @SerializedName("col")
  private Integer col;

  @SerializedName("len")
  private Integer len;

  @SerializedName("word")
  private String word;

  @SerializedName("s")
  public List<String> suggestion = new ArrayList<String>();

  public void setCode(Integer code) {this.code = code;}
  public Integer getCode() {return code;}

  public void setPos(Integer pos) {this.pos = pos;}
  public Integer getPos() {return pos;}

  public void setRow(Integer row) {this.row = row;}
  public Integer getRow() {return row;}

  public void setCol(Integer col) {this.col = col;}
  public Integer getCol() {return col;}

  public void setLen(Integer len) {this.len = len;}
  public Integer getLen() {return len;}

  public void setWord(String word) {this.word = word;}
  public String getWord() {return word;}

  public void setSuggestion(List<String> suggestion) {this.suggestion = suggestion;}
  public List<String> getSuggestion() {return suggestion;}

  public YandexSpeller() {}

  @Override
  public String toString() {
    return "YandexSpeller[" +
        "code='" + code + '\'' +
        "pos='" + pos + '\'' +
        "row='" + row + '\'' +
        "col='" + col + '\'' +
        "len='" + len + '\'' +
        "word='" + word + '\'' +
        "s='" + suggestion + '\'' +
        '}';
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder()
        .append(code)
        .append(pos)
        .append(row)
        .append(col)
        .append(len)
        .append(word)
        .append(suggestion)
        .toHashCode();
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    YandexSpeller ySpeller = (YandexSpeller) other;

    if (code != null ? !code.equals(ySpeller.code) : ySpeller.code != null) {
      return false;
    }
    if (pos != null ? !pos.equals(ySpeller.pos) : ySpeller.pos != null) {
      return false;
    }
    if (row != null ? !row.equals(ySpeller.row) : ySpeller.row != null) {
      return false;
    }
    if (col != null ? !col.equals(ySpeller.col) : ySpeller.col != null) {
      return false;
    }
    if (len != null ? !len.equals(ySpeller.len) : ySpeller.len != null) {
      return false;
    }
    if (word != null ? !word.equals(ySpeller.word) : ySpeller.word != null) {
      return false;
    }
    if (suggestion != null) {
      return equalLists(suggestion, ySpeller.suggestion);
    }
    return true;
  }
}
