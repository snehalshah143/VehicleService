package com.snehal.carservice.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Set;

@JsonInclude(Include.NON_NULL)
public class OrderJsonDto extends AbstractJsonDto {

  private Long orderId;

  @JsonIgnore private String booking;

  private String orderStatus;

  private String userVehicleDetail;

  private String assignments;

  private ProductJsonDto product;

  public OrderJsonDto() {
    super();
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public BookingJsonDto getBooking() {
    ObjectMapper mapper = new ObjectMapper();
    BookingJsonDto bookingJsonDto = null;
    if (booking != null) {
      try {
        bookingJsonDto = mapper.readValue(booking, BookingJsonDto.class);
      } catch (JsonMappingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (JsonProcessingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    return bookingJsonDto;
  }

  public void setBooking(BookingJsonDto bookingJsonDto) {
    ObjectMapper mapper = new ObjectMapper();
    if (bookingJsonDto != null) {
      try {
        this.booking = mapper.writeValueAsString(bookingJsonDto);
      } catch (JsonProcessingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

  public String getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(String orderStatus) {
    this.orderStatus = orderStatus;
  }

  public UserVehicleDetailJsonDto getUserVehicleDetail() {

    ObjectMapper mapper = new ObjectMapper();
    UserVehicleDetailJsonDto userVehicleDetailJsonDto = null;
    if (userVehicleDetail != null) {
      try {
        userVehicleDetailJsonDto =
            mapper.readValue(userVehicleDetail, UserVehicleDetailJsonDto.class);
      } catch (JsonMappingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (JsonProcessingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    return userVehicleDetailJsonDto;
  }

  public void setUserVehicleDetail(UserVehicleDetailJsonDto userVehicleDetailJsonDto) {
    ObjectMapper mapper = new ObjectMapper();
    if (userVehicleDetailJsonDto != null) {
      try {
        this.userVehicleDetail = mapper.writeValueAsString(userVehicleDetailJsonDto);
      } catch (JsonProcessingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

  public ProductJsonDto getProduct() {
    return product;
  }

  public void setProduct(ProductJsonDto product) {
    this.product = product;
  }

  public Set<AssignmentJsonDto> getAssignments() {

    ObjectMapper mapper = new ObjectMapper();
    Set<AssignmentJsonDto> assignmentJsonDtoSet = null;
    if (assignments != null) {
      try {
        assignmentJsonDtoSet =
            mapper.readValue(assignments, new TypeReference<Set<AssignmentJsonDto>>() {});

      } catch (JsonMappingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (JsonProcessingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    return assignmentJsonDtoSet;
  }

  public void setAssignments(Set<AssignmentJsonDto> assignmentsSet) {
    ObjectMapper mapper = new ObjectMapper();
    if (assignmentsSet != null) {
      try {
        this.assignments = mapper.writeValueAsString(assignmentsSet);
      } catch (JsonProcessingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}
