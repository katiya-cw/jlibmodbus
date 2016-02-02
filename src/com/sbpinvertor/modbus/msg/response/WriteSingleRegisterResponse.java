package com.sbpinvertor.modbus.msg.response;

import com.sbpinvertor.modbus.Modbus;
import com.sbpinvertor.modbus.exception.ModbusNumberException;
import com.sbpinvertor.modbus.msg.base.AbstractWriteResponse;
import com.sbpinvertor.modbus.net.stream.base.ModbusInputStream;
import com.sbpinvertor.modbus.net.stream.base.ModbusOutputStream;
import com.sbpinvertor.modbus.utils.ModbusFunctionCode;

/**
 * Copyright (c) 2015-2016 JSC "Zavod "Invertor"
 * [http://www.sbp-invertor.ru]
 * <p/>
 * This file is part of JLibModbus.
 * <p/>
 * JLibModbus is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * <p/>
 * Authors: Vladislav Y. Kochedykov, software engineer.
 * email: vladislav.kochedykov@gmail.com
 */
public class WriteSingleRegisterResponse extends AbstractWriteResponse {

    int value;

    public WriteSingleRegisterResponse(int serverAddress) throws ModbusNumberException {
        super(serverAddress);
    }

    public WriteSingleRegisterResponse(int serverAddress, int startAddress, int value) throws ModbusNumberException {
        super(serverAddress, startAddress);
        if (!checkValue())
            throw new ModbusNumberException("Error in register value", startAddress);
        setValue(value);
    }

    @Override
    protected void readValue(ModbusInputStream fifo) {

    }

    @Override
    protected void writeValue(ModbusOutputStream fifo) {

    }

    protected boolean checkValue() {
        return Modbus.checkRegisterValue(getValue());
    }

    @Override
    public ModbusFunctionCode getFunction() {
        return ModbusFunctionCode.WRITE_SINGLE_REGISTER;
    }

    final protected int getValue() {
        return value;
    }

    final public void setValue(int value) {
        this.value = value;
    }
}
