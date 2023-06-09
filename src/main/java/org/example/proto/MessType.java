// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Message.proto

package org.example.proto;

/**
 * Protobuf enum {@code proto.MessType}
 */
public enum MessType
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>ask_connect = 0;</code>
   */
  ask_connect(0),
  /**
   * <code>ask_refresh = 1;</code>
   */
  ask_refresh(1),
  /**
   * <code>ask_rb = 2;</code>
   */
  ask_rb(2),
  /**
   * <code>ask_disconnect = 3;</code>
   */
  ask_disconnect(3),
  /**
   * <code>win_lose = 4;</code>
   */
  win_lose(4),
  /**
   * <code>take_chess = 5;</code>
   */
  take_chess(5),
  /**
   * <code>move_chess = 6;</code>
   */
  move_chess(6),
  /**
   * <code>heart_beat = 7;</code>
   */
  heart_beat(7),
  /**
   * <code>has_lose_connect = 8;</code>
   */
  has_lose_connect(8),
  /**
   * <code>set_chess_location = 9;</code>
   */
  set_chess_location(9),
  /**
   * <code>set_chess_life = 10;</code>
   */
  set_chess_life(10),
  /**
   * <code>send_message = 11;</code>
   */
  send_message(11),
  /**
   * <pre>
   *请求加载棋谱
   * </pre>
   *
   * <code>ask_load_chess_map = 12;</code>
   */
  ask_load_chess_map(12),
  /**
   * <pre>
   *请求读取棋谱
   * </pre>
   *
   * <code>ask_sava_chess_map = 13;</code>
   */
  ask_sava_chess_map(13),
  /**
   * <pre>
   *设置客户端的回合属性和剩余时间
   * </pre>
   *
   * <code>set_round_and_time = 14;</code>
   */
  set_round_and_time(14),
  /**
   * <pre>
   *放在messArray首部,代表这个messes是一个整体为refresh包
   * </pre>
   *
   * <code>refresh = 15;</code>
   */
  refresh(15),
  /**
   * <pre>
   *放在messArray首部,代表这个messes是一个整体为load包
   * </pre>
   *
   * <code>load = 16;</code>
   */
  load(16),
  /**
   * <pre>
   *放在messArray首部,代表这个messes是一个整体为save包
   * </pre>
   *
   * <code>save = 17;</code>
   */
  save(17),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>ask_connect = 0;</code>
   */
  public static final int ask_connect_VALUE = 0;
  /**
   * <code>ask_refresh = 1;</code>
   */
  public static final int ask_refresh_VALUE = 1;
  /**
   * <code>ask_rb = 2;</code>
   */
  public static final int ask_rb_VALUE = 2;
  /**
   * <code>ask_disconnect = 3;</code>
   */
  public static final int ask_disconnect_VALUE = 3;
  /**
   * <code>win_lose = 4;</code>
   */
  public static final int win_lose_VALUE = 4;
  /**
   * <code>take_chess = 5;</code>
   */
  public static final int take_chess_VALUE = 5;
  /**
   * <code>move_chess = 6;</code>
   */
  public static final int move_chess_VALUE = 6;
  /**
   * <code>heart_beat = 7;</code>
   */
  public static final int heart_beat_VALUE = 7;
  /**
   * <code>has_lose_connect = 8;</code>
   */
  public static final int has_lose_connect_VALUE = 8;
  /**
   * <code>set_chess_location = 9;</code>
   */
  public static final int set_chess_location_VALUE = 9;
  /**
   * <code>set_chess_life = 10;</code>
   */
  public static final int set_chess_life_VALUE = 10;
  /**
   * <code>send_message = 11;</code>
   */
  public static final int send_message_VALUE = 11;
  /**
   * <pre>
   *请求加载棋谱
   * </pre>
   *
   * <code>ask_load_chess_map = 12;</code>
   */
  public static final int ask_load_chess_map_VALUE = 12;
  /**
   * <pre>
   *请求读取棋谱
   * </pre>
   *
   * <code>ask_sava_chess_map = 13;</code>
   */
  public static final int ask_sava_chess_map_VALUE = 13;
  /**
   * <pre>
   *设置客户端的回合属性和剩余时间
   * </pre>
   *
   * <code>set_round_and_time = 14;</code>
   */
  public static final int set_round_and_time_VALUE = 14;
  /**
   * <pre>
   *放在messArray首部,代表这个messes是一个整体为refresh包
   * </pre>
   *
   * <code>refresh = 15;</code>
   */
  public static final int refresh_VALUE = 15;
  /**
   * <pre>
   *放在messArray首部,代表这个messes是一个整体为load包
   * </pre>
   *
   * <code>load = 16;</code>
   */
  public static final int load_VALUE = 16;
  /**
   * <pre>
   *放在messArray首部,代表这个messes是一个整体为save包
   * </pre>
   *
   * <code>save = 17;</code>
   */
  public static final int save_VALUE = 17;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static MessType valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static MessType forNumber(int value) {
    switch (value) {
      case 0: return ask_connect;
      case 1: return ask_refresh;
      case 2: return ask_rb;
      case 3: return ask_disconnect;
      case 4: return win_lose;
      case 5: return take_chess;
      case 6: return move_chess;
      case 7: return heart_beat;
      case 8: return has_lose_connect;
      case 9: return set_chess_location;
      case 10: return set_chess_life;
      case 11: return send_message;
      case 12: return ask_load_chess_map;
      case 13: return ask_sava_chess_map;
      case 14: return set_round_and_time;
      case 15: return refresh;
      case 16: return load;
      case 17: return save;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<MessType>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      MessType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<MessType>() {
          public MessType findValueByNumber(int number) {
            return MessType.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return org.example.proto.MessProto.getDescriptor().getEnumTypes().get(0);
  }

  private static final MessType[] VALUES = values();

  public static MessType valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private MessType(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:proto.MessType)
}

