package org.cloudburstmc.protocol.bedrock.data.command;

public enum CommandParamType {
    UNKNOWN,
    INT,
    FLOAT,
    VALUE,
    R_VALUE, // TODO: unknown
    WILDCARD_INT,
    OPERATOR,
    COMPARE_OPERATOR,
    TARGET,
    UNKNOWN_STANDALONE,// TODO: unknown - STANDALONESELECTION
    WILDCARD_TARGET,
    UNKNOWN_NON_ID,// TODO: unknown - NONIDSELECTION
    SCORE_ARG,
    SCORE_ARGS,
    SCORE_SELECT_PARAM,
    SCORE_SELECTOR,
    TAG_SELECTOR,
    FILE_PATH,
    FILE_PATH_VAL, // TODO: unknown
    FILE_PATH_CONT, // TODO: unknown
    INT_RANGE_VAL, // TODO: unknown
    INT_RANGE_POST_VAL, // TODO: unknown
    INT_RANGE,
    INT_RANGE_FULL,
    SEL_ARGS, // TODO: unknown
    ARGS,
    ARG,
    MARG, // TODO: unknown
    MVALUE, // TODO: unknown
    NAME, // TODO: unknown
    TYPE, // TODO: unknown
    FAMILY, // TODO: unknown
    PERMISSION,
    PERMISSIONS,
    PERMISSION_SELECTOR,
    PERMISSION_ELEMENT,
    PERMISSION_ELEMENTS,
    TAG,
    HAS_ITEM_ELEMENT, // TODO: unknown
    HAS_ITEM_ELEMENTS, // TODO: unknown
    HAS_ITEM, // TODO: unknown
    HAS_ITEMS, // TODO: unknown
    HAS_ITEM_SELECTOR, // TODO: unknown
    EQUIPMENT_SLOTS,
    STRING,
    ID_CONT, // TODO: unknown
    COORD_X_INT,
    COORD_Y_INT,
    COORD_Z_INT,
    COORD_X_FLOAT,
    COORD_Y_FLOAT,
    COORD_Z_FLOAT,
    BLOCK_POSITION, // POSITION_INT
    POSITION, // POSITION_FLOAT
    MESSAGE_XP, // TODO: unknown
    MESSAGE,
    MESSAGE_ROOT, // TODO: unknown
    POST_SELECTOR,
    TEXT,
    TEXT_CONT, // TODO: unknown
    JSON_VALUE,
    JSON_FIELD,
    JSON,
    JSON_OBJECT_FIELDS,
    JSON_OBJECT_CONT, // TODO: unknown - maybe count?
    JSON_ARRAY,
    JSON_ARRAY_VALUES,
    JSON_ARRAY_CONT, // TODO: unknown - maybe count?
    BLOCK_STATE,
    BLOCK_STATE_KEY,
    BLOCK_STATE_VALUE,
    BLOCK_STATE_VALUES,
    BLOCK_STATES,
    BLOCK_STATES_CONT, // TODO: unknown - maybe count?
    COMMAND,
    SLASH_COMMAND,
    CHAINED_COMMAND
}
