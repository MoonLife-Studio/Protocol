package org.cloudburstmc.protocol.bedrock.codec.v557;

import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import org.cloudburstmc.protocol.bedrock.codec.EntityDataTypeMap;
import org.cloudburstmc.protocol.bedrock.codec.v554.BedrockCodecHelper_v554;
import org.cloudburstmc.protocol.bedrock.data.entity.EntityProperties;
import org.cloudburstmc.protocol.bedrock.data.entity.FloatEntityProperty;
import org.cloudburstmc.protocol.bedrock.data.entity.IntEntityProperty;
import org.cloudburstmc.protocol.bedrock.data.inventory.descriptor.ItemDescriptorWithCount;
import org.cloudburstmc.protocol.bedrock.data.inventory.stackrequestactions.AutoCraftRecipeStackRequestActionData;
import org.cloudburstmc.protocol.bedrock.data.inventory.stackrequestactions.StackRequestActionData;
import org.cloudburstmc.protocol.bedrock.data.inventory.stackrequestactions.StackRequestActionType;
import org.cloudburstmc.protocol.common.util.TypeMap;
import org.cloudburstmc.protocol.common.util.VarInts;

import java.util.List;

public class BedrockCodecHelper_v557 extends BedrockCodecHelper_v554 {

    public BedrockCodecHelper_v557(EntityDataTypeMap entityData, TypeMap<Class<?>> gameRulesTypes,
                                   TypeMap<StackRequestActionType> stackRequestActionTypes) {
        super(entityData, gameRulesTypes, stackRequestActionTypes);
    }

    @Override
    public void readEntityProperties(ByteBuf buffer, EntityProperties properties) {
        readArray(buffer, properties.getIntProperties(), byteBuf -> {
            int index = VarInts.readUnsignedInt(byteBuf);
            int value = VarInts.readInt(byteBuf);
            return new IntEntityProperty(index, value);
        });
        readArray(buffer, properties.getFloatProperties(), byteBuf -> {
            int index = VarInts.readUnsignedInt(byteBuf);
            float value = byteBuf.readFloatLE();
            return new FloatEntityProperty(index, value);
        });
    }

    @Override
    public void writeEntityProperties(ByteBuf buffer, EntityProperties properties) {
        writeArray(buffer, properties.getIntProperties(), (byteBuf, property) -> {
            VarInts.writeUnsignedInt(byteBuf, property.getIndex());
            VarInts.writeInt(byteBuf, property.getValue());
        });
        writeArray(buffer, properties.getFloatProperties(), (byteBuf, property) -> {
            VarInts.writeUnsignedInt(byteBuf, property.getIndex());
            byteBuf.writeFloatLE(property.getValue());
        });
    }

    @Override
    protected StackRequestActionData readRequestActionData(ByteBuf byteBuf, StackRequestActionType type) {
        if (type == StackRequestActionType.CRAFT_RECIPE_AUTO) {
            int recipeId = VarInts.readUnsignedInt(byteBuf);
            byte timesCrafted = byteBuf.readByte();
            List<ItemDescriptorWithCount> ingredients = new ObjectArrayList<>();
            readArray(byteBuf, ingredients, ByteBuf::readUnsignedByte, (buf, helper) -> helper.readIngredient(buf));
            return new AutoCraftRecipeStackRequestActionData(
                    recipeId,
                    timesCrafted,
                    ingredients
            );
        } else {
            return super.readRequestActionData(byteBuf, type);
        }
    }

    @Override
    protected void writeRequestActionData(ByteBuf byteBuf, StackRequestActionData action) {
        super.writeRequestActionData(byteBuf, action);
        if (action.getType() == StackRequestActionType.CRAFT_RECIPE_AUTO) {
            List<ItemDescriptorWithCount> ingredients = ((AutoCraftRecipeStackRequestActionData) action).getIngredients();
            byteBuf.writeByte(ingredients.size());
            writeArray(byteBuf, ingredients, this::writeIngredient);
        }
    }
}
