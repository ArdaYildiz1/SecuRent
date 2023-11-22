import Button from 'react-bootstrap/esm/Button';
import React from 'react';
import pp from './defaultPP.jpg';

function SelectAgent() {
    const dynamicData = ['Ahmet Kalem', 'Fatih Kor', 'Ali Tarık', 'Ahmet Kalem', 'Fatih Kor', 'Ali Tarık', 'Ahmet Kalem', 'Fatih Kor', 'Ali Tarık', 'Mehmet Ersoy', 'Fatih Kor', 'Ali Tarık', 'Mehmet Ersoy', 'Fatih Kor', 'Ali Tarık', 'Mehmet Ersoy'];
    const numbersArray = [4.2, 2.2, 3, 4, 5, 5, 4, 3, 4, 3, 2, 3, 4, 4, 3, 5];

    const DynamicList = ({ data, numbers }) => {
        return (
            <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
                <ul style={{ listStyle: 'none', padding: 0, width: '80%' }}>
                    {data.map((item, index) => (
                        <div key={index} style={{ borderBottom: '1px solid black', padding: '10px', display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>

                            <div style={{ display: 'flex', alignItems: 'center' }}>
                                <span style={{ marginLeft: '5px', color: 'balck', fontSize: 30, marginRight: '30px' }}> {numbers[index].toFixed(1)}  ★</span>

                                <img src={pp} style={{ marginRight: '10px', width: '50px', height: '50px', borderRadius: '50%' }} />
                                <span> {item}</span>
                            </div>

                            <Button style={{ backgroundColor: '#2D9596', borderColor: '#2D9596' }}>Select Agent</Button>

                        </div>
                    ))}
                </ul>
            </div>
        );
    };

    return (
        <div style={{ width: '100%', height: '100vh', backgroundColor: '#9AD0C2', overflowY: 'auto' }}>
            <div style={{ display: 'flex', justifyContent: 'center', paddingTop: '2%' }}>
                <h1>
                    Real Estate Agents
                </h1>
            </div>

            <div style={{ width: '100%', height: '100vh', backgroundColor: '#9AD0C2' }}>
                <DynamicList data={dynamicData} numbers={numbersArray} />
            </div>
        </div>
    );
}

export default SelectAgent;
